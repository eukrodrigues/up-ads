using Microsoft.EntityFrameworkCore;
public static class ProfessorApi
{
    public static void MapProfessorApi(this WebApplication app){
        var group = app.MapGroup("/Professor");

        group.MapGet("/", async(BancoDeDados db) => {
            return await db.Professores.ToListAsync();
        });

        group.MapPost("/", async(Professor Professor, BancoDeDados db) => {
            db.Professores.Add(Professor);
            await db.SaveChangesAsync();

            return Results.Created($"/Professor/{Professor.Id}", Professor);
        });

        group.MapPut("/{id}", async(int Id, Professor ProfessorAlterado, BancoDeDados db) => {
            var Professor = await db.Professores.FindAsync(Id);
            if(Professor is null){
                return Results.NotFound();
            }

            Professor.Nome = ProfessorAlterado.Nome;
            Professor.DataNascimento = ProfessorAlterado.DataNascimento;
            Professor.Turno = ProfessorAlterado.Turno;

            await db.SaveChangesAsync();

            return Results.NoContent();
        });

        group.MapDelete("/{id}", async(int Id, BancoDeDados db) => {
            if (await db.Professores.FindAsync(Id) is Professor Professor) {
                db.Professores.Remove(Professor);
                await db.SaveChangesAsync();

                return Results.NoContent();
            }

            return Results.NotFound();
        });
    }
}