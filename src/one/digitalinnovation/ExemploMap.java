package one.digitalinnovation;

/*
Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
Modelo: Dodge Charger   Consumo: 14,4Km/L
Modelo: Camaro SS       Consumo: 15,6Km/L
Modelo: Mustang Cobra   Consumo: 16,1Km/L
Modelo: Corvette         Consumo: 14,5Km/L
Modelo: Maverick        Consumo: 15,6Km/L
(Consumo meramente ilustrativo.)
*/

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        System.out.println("Crie um dicionário que relacione os modelos e seus" +
                "respectivos consumos:");
        Map<String, Double> carros = new HashMap<>() {{
            put("Dodge Charger", 14.4);
            put("Camaro SS", 15.6);
            put("Mustang Cobra", 16.1);
            put("Corvette", 14.5);
            put("Maverick", 15.6);
        }};
        System.out.println(carros);

        System.out.println("\nSubstitua o consumo do Dodge Charger para 15.2Km/L: ");
        carros.put("Dodge Charger", 15.2);//Sobrescreve o valor da chave pois não pode haver duas chaves iguais.
        System.out.println(carros.toString());

        System.out.print("\nConfira se o modelo Tucson está no dicionário: ");
        System.out.println(carros.containsKey("Tucson"));//É case-sensitive.

        System.out.print("\nExiba o consumo do Corvette: ");
        System.out.println(carros.get("Corvette"));

        //System.out.print("\nExiba o terceiro modelo adicionado: ");
        //Não podemos exibir com base no indice pois estamos utilizando Hash.

        System.out.println("\nExiba os modelos: ");
        //carros.keySet(); -> Devolve um Set com as chaves
        Set<String> modelos = carros.keySet();
        System.out.println(modelos);

        System.out.println("\nExiba o consumo dos carros:");
        //carros.values(); -> Devolve uma Collection com os valores.
        Collection<Double> consumos = carros.values();
        System.out.println(consumos);

        System.out.println("\nExiba o modelo MAIS econômico e seu consumo:");
        Double consumoMaisEficiente = Collections.max(carros.values());//Lembra? O .values() devolve uma Collection :)
        //Para pegarmos o modelo do carro com o consumo mais eficiente, vamos utilizar o método entreySet.
        //carros.entrySet(); -> Devolve um Set do tipo Entry.
        Set<Map.Entry<String, Double>> entries = carros.entrySet();//Cada elemento desse Set é do tipo Map.Entry
        String modeloMaisEficiente = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " +
                        modeloMaisEficiente + ", Consumo: " + consumoMaisEficiente + "Km/L");
                //Deixando o print dentro do loop, caso haja valores iguais, ambos serão exibidos.
                //Mudar o valor de algum outro carro para visualizar.
            }
        }

        System.out.println("\nExiba o modelo MENOS econômico e seu consumo:");
        Double consumoMenosEficiente = Collections.min(carros.values());
        String modeloMenosEficiente = "";
        //Ja temos um Set do tipo Map.Entry, vamos reutiliza-lo.
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " +
                        modeloMenosEficiente + ", Consumo: " + consumoMenosEficiente + "Km/L");
            }
        }

        System.out.print("\nExiba a soma dos consumos: ");
        Double soma = 0d;
        Iterator<Double> iterator = carros.values().iterator();
        while (iterator.hasNext()) soma += iterator.next();
        System.out.println(soma + "Km/L");

        System.out.print("\nExiba a média dos consumos deste dicionário de carros: ");
        System.out.println(soma / carros.size());

        System.out.println("\nRemova os modelos com o consumo igual a 15,6Km/L: ");
        Iterator<Double> iteratorRemove = carros.values().iterator();
        while (iteratorRemove.hasNext()) {
            if (iteratorRemove.next().equals(15.6))
                iteratorRemove.remove();
        }
        System.out.println(carros);

        System.out.println("\nExiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosLinked = new LinkedHashMap<>() {{
            put("Dodge Charger", 14.4);
            put("Camaro SS", 15.6);
            put("Mustang Cobra", 16.1);
            put("Corvette", 14.5);
            put("Maverick", 15.6);
        }};
        System.out.println(carrosLinked);

        System.out.println("\nExiba o dicionário ordenado pelo modelo: ");//Ordenado = Tree
        Map<String, Double> carrosTree = new TreeMap<>(carrosLinked);
        System.out.println(carrosTree);

        System.out.println("\nApague o dicionário de carros.");
        carros.clear();

        System.out.println("\nConfira se o dicionário esta vazio: " + carros.isEmpty());
        System.out.println("Carros: " + carros);
        System.out.println("CarrosLinked: " + carrosLinked);
        System.out.println("CarrosTree: " + carrosTree);

    }
}
