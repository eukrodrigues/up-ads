package Implementacao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(3);
        numeros.add(1);
        numeros.add(6);
        numeros.add(9);
        numeros.add(3);
        numeros.add(4);
        // Array: 1, 3, 1, 6, 9, 3, 4

        Set<Integer> numerosSemRepeticao = new HashSet<>();
        
        for(Integer numero : numeros){
            if(!numerosSemRepeticao.add(numero)){
                System.out.println("Número Repetido: " + numero);
            }
        }

        System.out.println("Impressão da lista");
        Iterator<Integer> it = numerosSemRepeticao.iterator();
        while(it.hasNext()){
            Integer numero = it.next();
            System.out.println(numero);
        }

    }
}
