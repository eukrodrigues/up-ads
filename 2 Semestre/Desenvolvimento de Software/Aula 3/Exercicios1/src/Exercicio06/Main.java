package Exercicio06;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scan = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("Digite a opção desejada: ");
            opcao = getInt("1 - Adicionar Contato\n2 - Remover Contato\n3 - Buscar por nome\n4 - Sair", scan);

            switch (opcao) {
                case 1:
                    agenda = adicionarContato(agenda, scan);
                    break;
                case 2:
                    agenda = removerContato(agenda, scan);
                    break;
                case 3:
                    buscarContatosPorNome(agenda, scan);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }

        } while(opcao != 4);

        scan.close();
    }

    private static Agenda adicionarContato(Agenda agenda, Scanner scan){
        String nome, telefone;

        scan.nextLine();
        nome = getTexto("Digite o nome do contato: ", scan);
        telefone = getTexto("Digite o telefone do contato: ", scan);

        System.out.println("Contato adicionado com sucesso!");
        return agenda.adicionarContato(new Contato(nome, telefone));
    }

    private static Agenda removerContato(Agenda agenda, Scanner scan){
        int index;
        agenda.listarContatos();
        index = getInt("Digite o número do contato que deseja excluir: ", scan);

        if(index >= 0 && index < agenda.getContatos().size()){
            agenda.removerContato(index);
        } else {
            System.out.println("Contato Inválido.");
        }

        return agenda;
    }

    private static void buscarContatosPorNome(Agenda agenda, Scanner scan){
        String nome;
        List<Contato> contatos;
        
        scan.nextLine();
        nome = getTexto("Digite o nome do contato que está procurando: ", scan);
        contatos = agenda.buscarContatosPorNome(nome);

        if(contatos != null && contatos.size() > 0){
            System.out.println("Contatos encontrados: ");
            for (Contato contato : contatos) {
                System.out.println("##################");
                System.out.println(contato.toString());
            }
        } else {
            System.out.println("Nenhum contato encontrado.");
        }
    }

    private static String getTexto(String mensagem, Scanner scan){
        String retorno;

        System.out.println(mensagem);
        retorno = scan.nextLine();

        return retorno;
    }

    private static int getInt(String mensagem, Scanner scan){
        int retorno;

        System.out.println(mensagem);
        retorno = scan.nextInt();

        return retorno;
    }
}
