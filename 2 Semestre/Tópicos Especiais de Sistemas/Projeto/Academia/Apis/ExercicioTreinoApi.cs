using Microsoft.EntityFrameworkCore;

public static class ExercicioTreinoApi
{
    public static void MapExercicioTreinoApi(this WebApplication app){
        var group = app.MapGroup("/exercicio-treino");

        group.MapGet("/", async(BancoDeDados db) => {
            return await db.ExerciciosTreinos.Include(e => e.Exercicio).ToListAsync();
        });

        group.MapPost("/", async(ExercicioTreino ExercicioTreino, BancoDeDados db) => {
            ExercicioTreino.Exercicio = await tratarExercicio(ExercicioTreino.Exercicio, db);

            db.ExerciciosTreinos.Add(ExercicioTreino);
            await db.SaveChangesAsync();

            return Results.Created($"/exercicio-treino/{ExercicioTreino.Id}", ExercicioTreino);
        });

        group.MapPut("/{id}", async(int Id, ExercicioTreino ExercicioTreinoAlterado, BancoDeDados db) => {
            var exercicioTreino = await db.ExerciciosTreinos.FindAsync(Id);
            if(exercicioTreino is null){
                return Results.NotFound();
            }

            exercicioTreino.Exercicio = await tratarExercicio(ExercicioTreinoAlterado.Exercicio, db);
            exercicioTreino.Repeticoes = ExercicioTreinoAlterado.Repeticoes;
            exercicioTreino.Series = ExercicioTreinoAlterado.Series;

            await db.SaveChangesAsync();

            return Results.NoContent();
        });

        group.MapDelete("/{id}", async(int Id, BancoDeDados db) => {
            if(await db.ExerciciosTreinos.FindAsync(Id) is ExercicioTreino exercicioTreino){
                db.ExerciciosTreinos.Remove(exercicioTreino);
                await db.SaveChangesAsync();

                return Results.NoContent();
            }

            return Results.NotFound();
        });

        async Task<Exercicio> tratarExercicio(Exercicio Exercicio, BancoDeDados db){
            if(Exercicio is not null){
                var exercicioExistente = await db.Exercicios.FindAsync(Exercicio.Id);

                if(exercicioExistente is not null){
                    return exercicioExistente;
                } else {
                    db.Exercicios.Add(Exercicio);
                    await db.SaveChangesAsync();
                }
            }

            return Exercicio;
        }
    }  
}