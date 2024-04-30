using Microsoft.EntityFrameworkCore;

public class BancoDeDados : DbContext
{
  protected override void OnConfiguring(DbContextOptionsBuilder builder) {
    builder.UseMySQL("server=localhost;port=3306;database=academia;user=root;password=c4s4d4m4r14!");
  }

  public DbSet<Aluno> Alunos { get; set; }
  public DbSet<Professor> Professores { get; set; }
  public DbSet<Treino> Treinos { get; set; }
  public DbSet<Exercicio> Exercicios { get; set;}
  public DbSet<ExercicioTreino> ExerciciosTreinos { get; set;}
  public DbSet<Execucao> Execucoes { get; set; }
}