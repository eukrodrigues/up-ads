package Performance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestePerformance {

    public static void main(String[] args) {
        TesteArrayList();
        TesteHashSet();
    }

    public static void TesteArrayList(){
        System.out.println("Iniciando Teste ArrayList");
        Collection<Integer> teste = new ArrayList<>();
        long inicio = System.currentTimeMillis();

        int total = 30000;

        // Adicionando Elemento no ArrayList
        for (int i = 0; i < total; i++) {
            teste.add(i);
        }

        // Pesquisando Elemento no ArrayList
        for (int i = 0; i < total; i++) {
            teste.contains(i);
        }

        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo gasto: " + tempo);
    }

    public static void TesteHashSet(){
        System.out.println("Iniciando Teste HashSet");
        Collection<Integer> teste = new HashSet<>();
        long inicio = System.currentTimeMillis();

        int total = 30000;

        // Adicionando Elemento no ArrayList
        for (int i = 0; i < total; i++) {
            teste.add(i);
        }

        // Pesquisando Elemento no ArrayList
        for (int i = 0; i < total; i++) {
            teste.contains(i);
        }

        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo gasto: " + tempo);
    }
}
