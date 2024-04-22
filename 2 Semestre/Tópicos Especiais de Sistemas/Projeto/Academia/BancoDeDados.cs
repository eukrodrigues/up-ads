using Microsoft.EntityFrameworkCore;

public class BancoDeDados : DbContext
{
  protected override void OnConfiguring(DbContextOptionsBuilder builder) {
    builder.UseMySQL("server=localhost;port=3306;database=academia;user=root;password=");
  }

  public DbSet<Pessoa> Pessoas { get; set; }
}