import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controllers.AlunoController;
import controllers.ExercicioController;
import controllers.ProfessorController;
import entities.Aluno;
import entities.Exercicio;
import entities.ExercicioTreino;
import entities.Professor;
import entities.Servico;
import entities.Treino;
import enums.Dificuldade;
import enums.RegiaoExercicio;
import enums.Turno;
import exceptions.AlunoNaoEncontradoException;
import exceptions.ServicoInexistenteException;

public class Aplicativo {
    AlunoController alunos = new AlunoController();
    ProfessorController professores = new ProfessorController();
    ExercicioController exercicios = new ExercicioController();

    public void executar(){
        Scanner scan = new Scanner(System.in);
        int opcao;

        while(true){
            System.out.println("------------------------------------");
            System.out.println("Digite uma opção para prosseguir: ");
            System.out.println("------------------------------------");
            System.out.println("1 | Adicionar Aluno ");
            System.out.println("2 | Adicionar Professor ");
            System.out.println("3 | Criar Treino ");
            System.out.println("4 | Pagar Mensalidade ");
            System.out.println("5 | Criar Exercicio ");
            System.out.println("------------------------------------");

            opcao = scan.nextInt();
            scan.nextLine();

            switch(opcao){
                case 1: 
                    adicionarAluno(scan);
                    break;
                case 2: 
                    adicionarProfessor(scan);
                    break;
                case 3: 
                    criarTreino(scan);
                    break;
                case 4:
                    pagarMensalidade(scan);
                    break;
                case 5:
                    criarExercicio(scan);
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }

    private void adicionarAluno(Scanner scan){
        String nome, cpf, matricula;
        double valorMensalidade;
        int servicoContratado;
        
        try{
            System.out.println("Digite o nome do aluno: ");
            nome = scan.nextLine();
            System.out.println("Digite o CPF:");
            cpf = scan.nextLine();
            System.out.println("Digite a matricula: ");
            matricula = scan.nextLine();
            System.out.println("Digite o valor da mensalidade: ");
            valorMensalidade = scan.nextDouble();
            System.out.println("Digite o serviço contratado: (1) Musculacao | (2) Spinning | (3) Judo | (4) Karate | (5) MuayThai");
            servicoContratado = scan.nextInt();
            

            alunos.adicionarAluno(new Aluno(nome, cpf, matricula, valorMensalidade, List.of(Servico.fromId(servicoContratado)), new Date()));
            
            System.out.println("Aluno adicionado com sucesso!");
        } catch(ServicoInexistenteException e){
            System.out.println(e.getMessage());
        }
    }

    private void adicionarProfessor(Scanner scan){
        String nome, cpf, codigoProfessor;
        double salario;
        int idTurno, servicoAtendido;
        
        try{
            System.out.println("Digite o nome do professor: ");
            nome = scan.nextLine();
            System.out.println("Digite o CPF:");
            cpf = scan.nextLine();
            System.out.println("Digite o código do professor: ");
            codigoProfessor = scan.nextLine();
            System.out.println("Digite o serviço atendido: (1) Musculacao | (2) Spinning | (3) Judo | (4) Karate | (5) MuayThai");
            servicoAtendido = scan.nextInt();
            System.out.println("Digite o turno: (1) Manhã | (2) Tarde | (3) Noite");
            idTurno = scan.nextInt();
            System.out.println("Digite o salario:");
            salario = scan.nextDouble();

            professores.adicionarProfessor(new Professor(nome, cpf, Turno.fromId(idTurno), salario, List.of(Servico.fromId(servicoAtendido)), codigoProfessor));
            
            System.out.println("Professor adicionado com sucesso!");
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    private void criarTreino(Scanner scan){
        String matricula, codigoProfessor;
        int idExercicio, repeticoes, series;
        Treino treino;
        Exercicio exercicio;

        try{
            System.out.println("Digite o código do professor:");
            codigoProfessor = scan.nextLine();
            treino = new Treino(professores.getProfessor(codigoProfessor), new Date(), 30);

            do {
                exercicios.exibirExercicios();
                System.out.println("Digite o número do exercício ou -1 para encerrar");
                idExercicio = scan.nextInt();

                if(idExercicio != -1){
                    exercicio = exercicios.getByIndex(idExercicio);
                    System.out.println("Digite a quantidade de séries: ");
                    series = scan.nextInt();
                    System.out.println("Digite a quantidade de repetições de cada série: ");
                    repeticoes = scan.nextInt();

                    treino.adicionarExercicio(new ExercicioTreino(exercicio, series, repeticoes));
                }
            } while(idExercicio != -1);

            scan.nextLine();
            System.out.println("Digite a matricula do aluno o qual o treino será associado: ");
            matricula = scan.nextLine();

            alunos.atualizarTreino(matricula, treino);
            System.out.println("Treino incluído com sucesso para aluno.");

        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    private void pagarMensalidade(Scanner scan){
        String matricula;

        System.out.println("Digite a matricula do aluno o qual o treino será associado: ");
        matricula = scan.nextLine();

        alunos.pagarMensalidade(matricula);
        System.out.println("Mensalidade paga com sucesso!");
    }

    private void criarExercicio(Scanner scan){
        String nome;
        int idRegiao, idDificuldade;
        try{
            System.out.println("Digite o nome do exercício: ");
            nome = scan.nextLine();
            System.out.println("Digite a região do exercicio: Perna Anterior(1), Perna Posterior(2), Ombro(3), Biceps(4), Triceps(5), Panturrilha(6), Abdomen(7)");
            idRegiao = scan.nextInt();
            System.out.println("Digite a dificuldade: Facil(1), Medio(2), Dificil(3), Muito Dificil(4)");
            idDificuldade = scan.nextInt();

            exercicios.adicionarExercicio(new Exercicio(nome, RegiaoExercicio.fromId(idRegiao), Dificuldade.fromId(idDificuldade)));
            System.out.println("Exercício criado com sucesso!");
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    private void visualizarTreino(Scanner scan){
        String matricula;

        try{
            System.out.println("Digite a matricula do aluno o qual o treino será associado: ");
            matricula = scan.nextLine();

            alunos.exibirTreino(matricula);
        } catch(AlunoNaoEncontradoException e){
            System.out.println(e.getMessage());
        }

    }
}
