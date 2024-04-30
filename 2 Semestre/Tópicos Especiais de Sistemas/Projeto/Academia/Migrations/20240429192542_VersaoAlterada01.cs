using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Academia.Migrations
{
    /// <inheritdoc />
    public partial class VersaoAlterada01 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<DateTime>(
                name: "DataNascimento",
                table: "Professores",
                type: "datetime(6)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Nome",
                table: "Professores",
                type: "longtext",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Turno",
                table: "Professores",
                type: "longtext",
                nullable: true);

            migrationBuilder.AlterColumn<string>(
                name: "Nome",
                table: "Alunos",
                type: "longtext",
                nullable: true,
                oldClrType: typeof(string),
                oldType: "longtext");

            migrationBuilder.AlterColumn<DateTime>(
                name: "DataNascimento",
                table: "Alunos",
                type: "datetime(6)",
                nullable: true,
                oldClrType: typeof(DateTime),
                oldType: "datetime(6)");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "DataNascimento",
                table: "Professores");

            migrationBuilder.DropColumn(
                name: "Nome",
                table: "Professores");

            migrationBuilder.DropColumn(
                name: "Turno",
                table: "Professores");

            migrationBuilder.AlterColumn<string>(
                name: "Nome",
                table: "Alunos",
                type: "longtext",
                nullable: false,
                defaultValue: "",
                oldClrType: typeof(string),
                oldType: "longtext",
                oldNullable: true);

            migrationBuilder.AlterColumn<DateTime>(
                name: "DataNascimento",
                table: "Alunos",
                type: "datetime(6)",
                nullable: false,
                defaultValue: new DateTime(1, 1, 1, 0, 0, 0, 0, DateTimeKind.Unspecified),
                oldClrType: typeof(DateTime),
                oldType: "datetime(6)",
                oldNullable: true);
        }
    }
}
