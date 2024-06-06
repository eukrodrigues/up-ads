using System.Text.Json;
using System.Text.Json.Serialization;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

//Configuração de CORs
builder.Services.AddCors();

builder.Services.Configure<Microsoft.AspNetCore.Http.Json.JsonOptions>(
    options => options.SerializerOptions.ReferenceHandler = ReferenceHandler.IgnoreCycles
);

builder.Services.AddDbContext<BancoDeDados>();

var app = builder.Build();

app.UseCors(builder => builder
  .AllowAnyOrigin()
  .AllowAnyHeader()
  .AllowAnyMethod()
);

app.UseSwagger();
app.UseSwaggerUI();

app.MapGet("/", () => "Hello World!");
app.MapAlunoApi();
app.MapProfessorApi();
app.MapExercicioApi();
app.MapExercicioTreinoApi();
app.MapTreinoApi();

app.Run();
