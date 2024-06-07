import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro(10, 10);
        Personagem personagem1 = new Player("O", 0, 0);
        Personagem personagem2 = new Inimigo("X", 9, 9);
        Personagem personagem3 = new Inimigo("|",5, 5);
        Personagem personagemAtual;

        tabuleiro.adicionarPersonagem(personagem1);
        tabuleiro.adicionarPersonagem(personagem2);
        tabuleiro.adicionarPersonagem(personagem3);

        do {
            personagemAtual = null;
            tabuleiro.exibirTabuleiro();

            System.out.println("Selecione o personagem: ");
            System.out.println("1 - " + personagem1.getRepresentacao());
            System.out.println("2 - " + personagem2.getRepresentacao());
            System.out.println("3 - " + personagem3.getRepresentacao());

            int opcao1 = scan.nextInt();
            if (opcao1 >= 1 && opcao1 <= 3){
                if(opcao1 == 1){
                    personagemAtual = personagem1;
                } else if(opcao1 == 2){
                    personagemAtual = personagem2;
                } else if(opcao1 == 3) {
                    personagemAtual = personagem3;
                }

                System.out.println("Digite o que deseja fazer: ");
                System.out.println("1 - Mover para Cima");
                System.out.println("2 - Mover para Baixo");
                System.out.println("3 - Mover para Direita");
                System.out.println("4 - Mover para Esquerda");

                int opcao2 = scan.nextInt();

                switch (opcao2) {
                    case 1:
                        personagemAtual = tabuleiro.moverParaCima(personagemAtual);
                        break;
                    case 2:
                        personagemAtual = tabuleiro.moverParaBaixo(personagemAtual);
                        break;
                    case 3:
                        personagemAtual = tabuleiro.moverParaDireita(personagemAtual);
                        break;
                    case 4:
                        personagemAtual = tabuleiro.moverParaEsquerda(personagemAtual);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                if(opcao1 == 1){
                    personagem1 = personagemAtual;
                } else if(opcao1 == 2){
                    personagem2 = personagemAtual;
                } else if(opcao1 == 3) {
                    personagem3 = personagemAtual;
                }
            }
        } while(true);

    }
}
