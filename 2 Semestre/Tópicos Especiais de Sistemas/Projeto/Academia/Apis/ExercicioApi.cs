using Microsoft.EntityFrameworkCore;

public static class ExercicioApi
{
    public static void MapExercicioApi(this WebApplication app){
        var group = app.MapGroup("/exercicio");

        group.MapGet("/", async(BancoDeDados db) => {
            return await db.Exercicios.ToListAsync();
        });

        group.MapPost("/", async(Exercicio Exercicio, BancoDeDados db) => {
            db.Exercicios.Add(Exercicio);
            await db.SaveChangesAsync();

            return Results.Created($"/exercicio/{Exercicio.Id}", Exercicio);
        });

        group.MapPut("/{id}", async(int Id, Exercicio ExercicioAlterado, BancoDeDados db) => {
            var Exercicio = await db.Exercicios.FindAsync(Id);
            if (Exercicio is null) return Results.NotFound();

            Exercicio.Nome = ExercicioAlterado.Nome;
            Exercicio.Numero = ExercicioAlterado.Numero;
            Exercicio.Dificuldade = ExercicioAlterado.Dificuldade;

            await db.SaveChangesAsync();

            return Results.NoContent();
        });

        group.MapDelete("/{id}", async(int Id, BancoDeDados db) => {
            if(await db.Exercicios.FindAsync(Id) is Exercicio exercicio){
                db.Exercicios.Remove(exercicio);
                await db.SaveChangesAsync();

                return Results.NoContent();
            }

            return Results.NotFound();
        });
    }
}