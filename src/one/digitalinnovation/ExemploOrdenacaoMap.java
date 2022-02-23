package one.digitalinnovation;

/*
Dada as informações dos seguintes livros e seus respectivos autores,
crie um dicionário e ordene o mesmo.
Exibição: (Nome Autor - Nome Livro)

Autor: J. R. R. Tolkien  Livro: Silmarillion.        Páginas: 353
Autor: Caldela, Leonel   Livro: Trilogia Tormenta.   Páginas: 1824
Autor: Brown, Dan        Livro: O Código Da Vinci.   Páginas: 540
 */

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("ORDEM ALEATÓRIA");//HashMap
        Map<String, Livro> livros = new HashMap<>() {{
            put("J. R. R. Tolkien", new Livro("Silmarillion", 353));
            put("Caldela, Leonel", new Livro("Trilogia Tormenta", 1824));
            put("Brown, Dan", new Livro("O Código Da Vinci", 540));
        }};
        for (Map.Entry<String, Livro> livroTemp : livros.entrySet()) {
            System.out.println(livroTemp.getKey() + " - " + livroTemp.getValue().getNome());
        }
        System.out.println("----------------------------------");

        System.out.println("ORDEM INSERÇÃO");//Linked
        Map<String, Livro> livrosLinked = new LinkedHashMap<>() {{
            put("J. R. R. Tolkien", new Livro("Silmarillion", 353));
            put("Caldela, Leonel", new Livro("Trilogia Tormenta", 1824));
            put("Brown, Dan", new Livro("O Código Da Vinci", 540));
        }};
        for (Map.Entry<String, Livro> livroTemp : livrosLinked.entrySet()) {
            System.out.println(livroTemp.getKey() + " - " + livroTemp.getValue().getNome());
        }
        System.out.println("----------------------------------");

        System.out.println("ORDEM ALFABÉTICA AUTORES");//Tree
        Map<String, Livro> livrosTree = new TreeMap<>(livrosLinked);
        for (Map.Entry<String, Livro> livroTemp : livrosTree.entrySet()) {
            System.out.println(livroTemp.getKey() + " - " + livroTemp.getValue().getNome());
        }
        System.out.println("----------------------------------");

        System.out.println("ORDEM ALFABÉTICA NOME DOS LIVROS");
        Set<Map.Entry<String, Livro>> livrosSetNome = new TreeSet<>(new ComparatorNome());
        livrosSetNome.addAll(livros.entrySet());//Relembrando, o entrySet devolve um Set.
        for (Map.Entry<String, Livro> livroTemp : livrosSetNome) {
            System.out.println(livroTemp.getKey() + " - " + livroTemp.getValue().getNome());
        }
        System.out.println("----------------------------------");

        System.out.println("ORDEM NÚMERO DE PAGINAS");
        Set<Map.Entry<String, Livro>> livrosSetPaginas = new TreeSet<>(new ComparatorPaginas());
        livrosSetPaginas.addAll(livrosSetNome);
        for (Map.Entry<String, Livro> livroTemp : livrosSetPaginas) {
            System.out.println(livroTemp.getKey() + " - " + livroTemp.getValue().getNome());
        }
        System.out.println("----------------------------------");
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}