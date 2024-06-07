package Exercicio06;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    List<Contato> contatos;

    public Agenda(){
        contatos = new ArrayList<>();
        carregarContatos();
    }

    public Agenda adicionarContato(Contato contato){
        contatos.add(contato);
        return this;
    }

    public Agenda removerContato(int indice){
        contatos.remove(indice);
        return this;
    }

    public void listarContatos(){
        for(int i = 0; i < contatos.size(); i++){
            System.out.println(i + " - " + contatos.get(i).toString());
        }
    }

    public List<Contato> buscarContatosPorNome(String nome){
        return contatos.stream()
                       .filter(contato -> contato.getNome().contains(nome))
                       .toList();
    }

    public List<Contato> getContatos(){
        return contatos;
    }

    private void carregarContatos(){
        contatos.add(new Contato("Kelvin Patrick", "41996949393"));
        contatos.add(new Contato("João", "41996949394"));
        contatos.add(new Contato("Maria", "41996949395"));
        contatos.add(new Contato("José Patrick", "41996949396"));
        contatos.add(new Contato("Inácio", "41996949397"));
    }
}
