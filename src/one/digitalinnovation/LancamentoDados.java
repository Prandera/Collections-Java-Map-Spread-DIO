package one.digitalinnovation;

/*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi inserido.
*/

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LancamentoDados {
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> lancamentoDado = new ArrayList<>();
        int um, dois, tres, quatro, cinco, seis;
        um = dois = tres = quatro = cinco = seis = 0;
        int lineBreaker = 1;


        System.out.println("Gerando os 100 lançamentos de um D6:");
        for (int i = 0; i < 100; i++) {
            lancamentoDado.add(random.nextInt(6) + 1);
            System.out.print(lancamentoDado.get(i) + " | ");
            if (lineBreaker % 10 == 0) System.out.println("");
            lineBreaker++;
        }

        for (Integer lancamento : lancamentoDado) {
            switch (lancamento) {
                case (1):
                    um++;
                    break;
                case (2):
                    dois++;
                    break;
                case (3):
                    tres++;
                    break;
                case (4):
                    quatro++;
                    break;
                case (5):
                    cinco++;
                    break;
                case (6):
                    seis++;
                    break;
            }
        }

        System.out.println("\nTotal para cada valor: ");
        System.out.println("Nº1: " + um);
        System.out.println("Nº2: " + dois);
        System.out.println("Nº3 : " + tres);
        System.out.println("Nº4: " + quatro);
        System.out.println("Nº5: " + cinco);
        System.out.println("Nº6: " + seis);
    }
}
