using Microsoft.EntityFrameworkCore;

public static class AlunoApi
{
    public static void MapAlunoApi(this WebApplication app){
        var group = app.MapGroup("/aluno");

        group.MapGet("/", async(BancoDeDados db) => {
            return await db.Alunos.ToListAsync();
        });

        group.MapPost("/", async(Aluno Aluno, BancoDeDados db) => {
            db.Alunos.Add(Aluno);
            await db.SaveChangesAsync();

            return Results.Created($"/aluno/{Aluno.Id}", Aluno);
        });

        group.MapPut("/{id}", async(int Id, Aluno alunoAlterado, BancoDeDados db) => {
            var aluno = await db.Alunos.FindAsync(Id);
            if(aluno is null){
                return Results.NotFound();
            }
            
            aluno.Nome = alunoAlterado.Nome;
            aluno.DataNascimento = alunoAlterado.DataNascimento;

            await db.SaveChangesAsync();

            return Results.NoContent();
        });

        group.MapDelete("/{id}", async(int Id, BancoDeDados db) => {
            if (await db.Alunos.FindAsync(Id) is Aluno aluno) {
                db.Alunos.Remove(aluno);
                await db.SaveChangesAsync();

                return Results.NoContent();
            }

            return Results.NotFound();
        });
    }
}