using Microsoft.EntityFrameworkCore;

public static class TreinoApi
{
    public static void MapTreinoApi(this WebApplication app){

        var group = app.MapGroup("/treino");

        group.MapGet("/", async(BancoDeDados db) => {
            return await db.Treinos
                                .Include(t => t.ExercicioTreino)
                                    .ThenInclude(et => et.Exercicio)
                                .Include(t => t.Aluno)
                                .Include(t => t.Professor)
                                .ToListAsync();
        });

        group.MapGet("/aluno/{id}", async(int Id, BancoDeDados db) => {
            return await db.Treinos
                .Where(t => t.Aluno.Id == Id)
                .Include(t => t.ExercicioTreino)
                    .ThenInclude(et => et.Exercicio)
                .Include(t => t.Aluno)
                .Include(t => t.Professor)
                .ToListAsync();
        });

        group.MapPost("/", async(Treino Treino, BancoDeDados db) => {
            Treino.ExercicioTreino = await tratarExercicioTreino(Treino, db);
            Treino.Aluno = await tratarAluno(Treino, db);
            Treino.Professor = await tratarProfessor(Treino, db);

            db.Treinos.Add(Treino);
            await db.SaveChangesAsync();

            return Results.Created($"/treino/{Treino.Id}", Treino);
        });

        group.MapPut("/{id}", async(int Id, Treino Treino, BancoDeDados db) => {
            var treinoExistente = await db.Treinos.FindAsync(Id);

            if(treinoExistente is not null) {
                treinoExistente.ExercicioTreino = await tratarExercicioTreino(Treino, db);
                treinoExistente.Aluno = await tratarAluno(Treino, db);
                treinoExistente.Professor = await tratarProfessor(Treino, db);

                await db.SaveChangesAsync();

                return Results.NoContent();
            }

            return Results.NotFound();
        });

        group.MapDelete("/{id}", async(int Id, BancoDeDados db) => {
            if(await db.Treinos.FindAsync(Id) is Treino treino){
                db.Treinos.Remove(treino);
                await db.SaveChangesAsync();

                return Results.NoContent();
            }

            return Results.NotFound();
        });

        async Task<List<ExercicioTreino>> tratarExercicioTreino(Treino Treino, BancoDeDados db){
            List<ExercicioTreino> exercTreinos = new();

            if(Treino is not null && Treino.ExercicioTreino is not null && 
                Treino.ExercicioTreino.Count > 0){

                foreach(ExercicioTreino exercTreino in Treino.ExercicioTreino){
                    var exercicioTreinoExistente = await db.ExerciciosTreinos.FindAsync(exercTreino.Id);

                    if(exercicioTreinoExistente is not null){
                        exercTreinos.Add(exercicioTreinoExistente);
                    } 
                    else {
                        db.ExerciciosTreinos.Add(exercTreino);
                        await db.SaveChangesAsync();

                        exercTreinos.Add(exercTreino);
                    }
                }
            }

            return exercTreinos;
        }

        async Task<Aluno> tratarAluno(Treino Treino, BancoDeDados db){
            if(Treino is not null && Treino.Aluno is not null){
                var aluno = await db.Alunos.FindAsync(Treino.Aluno.Id);

                if(aluno is not null) {
                    return aluno;
                }
            }

            return Treino.Aluno;
        }

        async Task<Professor> tratarProfessor(Treino Treino, BancoDeDados db){
            if(Treino is not null && Treino.Professor is not null){
                var professor = await db.Professores.FindAsync(Treino.Professor.Id);

                if(professor is not null){
                    return professor;
                }
            }

            return Treino.Professor;
        }
    }
}