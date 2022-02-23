package one.digitalinnovation;

/*
Dada a população estimada de alguns estados do NE brasileiro, faça:
Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265

Crie um dicionário e relacione os estados e suas populações;
Substitua a população do estado do RN por 3.534.165;
Confira se o estado PB está no dicionário, caso não adicione: PB -4.039.277;
Exiba a população PE.
Exiba todos os estados e suas populações na ordem que foi informado;
Exiba os estados e suas populações em ordem alfabética;
Exiba o estado com o menor população e sua quantidade;
Exiba o estado com a maior população e sua quantidade;
Exiba a soma da população desses estados;
Exiba a média da população deste dicionário de estados;
Remova os estados com a população menor que 4.000.000;
Apague o dicionário de estados;
Confira se o dicionário está vazio.
*/

import java.text.DecimalFormat;
import java.util.*;

public class PopulacaoEstados {
    public static void main(String[] args) {
        String formato = "###,###,###";
        DecimalFormat format = new DecimalFormat(formato);

        System.out.println("Crie um dicionário e relacione os estados e suas populações;");
        Map<String, Integer> populacao = new HashMap<>() {{
            put("PE", 9616321);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        System.out.println("\nSubstitua a população do estado do RN por 3.534.165;");
        populacao.put("RN", 3534165);

        System.out.println("\nConfira se o estado PB está no dicionário, caso não adicione: PB, 4.039.277: " + populacao.containsKey("PB"));
        populacao.put("PB", 4039277);

        System.out.println("\nExiba a população PE: " + format.format(populacao.get("PE")) + " habitantes.");

        System.out.println("\nExiba todos os estados e suas populações na ordem que foi informado;");
        Map<String, Integer> populacaoLinked = new LinkedHashMap<>() {{
            put("PE", 9616321);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};
        System.out.println(populacaoLinked.toString());

        System.out.println("\nExiba os estados e suas populações em ordem alfabética;");
        Map<String, Integer> populacaoTree = new TreeMap<>(populacaoLinked);
        System.out.println(populacaoTree);

        System.out.println("\nExiba o estado com o menor população e sua quantidade;");
        Integer menorPopulacao = Collections.min(populacao.values());
        Set<Map.Entry<String, Integer>> entries = populacao.entrySet();
        String estadoMenosPopuloso;
        for (Map.Entry<String, Integer> populacaoTemp : entries) {
            if (populacaoTemp.getValue().equals(menorPopulacao)) {
                estadoMenosPopuloso = populacaoTemp.getKey();
                System.out.println("Estado com menor população: " + estadoMenosPopuloso +
                        ".\nPopulação: " + format.format(menorPopulacao) + " habitantes.");
            }
        }

        System.out.println("\nExiba o estado com a maior população e sua quantidade;");
        Integer maiorPopulacao = Collections.max(populacao.values());
        String estadoMaisPopuloso;
        for (Map.Entry<String, Integer> populacaoTemp : entries) {
            if (populacaoTemp.getValue().equals(maiorPopulacao)) {
                estadoMaisPopuloso = populacaoTemp.getKey();
                System.out.println("Estado com a maior população: " + estadoMaisPopuloso +
                        ".\nPopulação: " + format.format(maiorPopulacao) + " habitantes.");
            }
        }

        System.out.println("\nExiba a soma da população desses estados;");
        Iterator<Integer> iterator = populacao.values().iterator();
        Integer soma = 0;
        while (iterator.hasNext()) soma += iterator.next();
        System.out.println("Soma da população: " + format.format(soma) + " habitantes.");

        System.out.println("\nExiba a média da população deste dicionário de estados;\nMédia: " + format.format(soma / populacao.size()) + " habitantes.");

        System.out.println("\nRemova os estados com a população menor que 4.000.000;");
        populacao.values().removeIf(integer -> integer < 4000000);
        System.out.println(populacao);

        System.out.println("\nApague o dicionário de estados;");
        populacao.clear();

        System.out.println("\nConfira se o dicionário está vazio;");
        System.out.println("População: " + populacao);
        System.out.println("PopulaçãoLinked: " + populacaoLinked);
        System.out.println("PopulaçãoTree: " + populacaoTree);
    }
}