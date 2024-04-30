using Microsoft.EntityFrameworkCore;

public static class ExecucaoApi
{
    public static void MapExecucaoApi(this WebApplication app){
        var group = app.MapGroup("/execucao");

        group.MapGet("/", async(BancoDeDados db) => {
            return await db.Execucoes.ToListAsync();
        });
        
    }
}