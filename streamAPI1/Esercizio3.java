
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Prodotto {
    private String nome, categoria;
    private double prezzo;

    public Prodotto

    (String nome, double prezzo, String categoria) {

        this.nome = nome;

        this.prezzo = prezzo;

        this.categoria = categoria;

    }

    public String getNome() {
        return nome;

    }

    public double getPrezzo() {
        return prezzo;

    }

    public String getCategoria() {
        return categoria;

    }

    public String toString() {
        return nome + " , " + prezzo + " , " + categoria;

    }
}

public class Esercizio3 {
    public static void main(String[] args) {
        List<Prodotto> prodotti = new ArrayList<Prodotto>();

        // Aggiunta di oggetti Prodotto alla lista
        prodotti.add(new Prodotto("Laptop", 1200.99, "Elettronica"));
        prodotti.add(new Prodotto("Smartphone", 699.49, "Elettronica"));
        prodotti.add(new Prodotto("Frigorifero", 499.99, "Elettrodomestici"));
        prodotti.add(new Prodotto("T-shirt", 19.99, "Abbigliamento"));
        prodotti.add(new Prodotto("Jeans", 49.99, "Abbigliamento"));
        prodotti.add(new Prodotto("Aspirapolvere", 150.75, "Elettrodomestici"));
        prodotti.add(new Prodotto("Libro", 12.99, "Cancelleria"));
        prodotti.add(new Prodotto("Penna", 2.49, "Cancelleria"));

        // 1. Filtrare i prodotti di una categoria specifica e con un prezzo superiore a
        // una certa soglia.
        System.out.println("Prodotti della categoria Elettronica sopra i 250$");
        List<Prodotto> prodCat = prodotti.stream()
                .filter(p -> p.getCategoria().equals("Elettronica") && p.getPrezzo() > 250)
                .collect(Collectors.toList());
        prodCat.forEach(item -> System.out.println(item.toString()));

        // 2. Trovare il prodotto più caro di ogni categoria

        /*
         * Ricordati quindi che il collectors.toMap ha tre parametri di ingresso:
         * - key
         * - value
         * - mergeFunction --> in caso di conflitto di valori associati alla stessa
         * chiave cosa fare
         */

        Map<String, Prodotto> prodottoPiuCaroPerCategoria = prodotti.stream()
                .collect(Collectors.toMap(
                        Prodotto::getCategoria, // Chiave: categoria
                        p -> p, // Valore: il prodotto stesso
                        (p1, p2) -> p1.getPrezzo() > p2.getPrezzo() ? p1 : p2 // Risoluzione dei conflitti: mantiene il
                                                                              // prodotto più caro
                ));
        prodottoPiuCaroPerCategoria.forEach((key, value) -> {
            System.out.println("Categoria: " + key);
            System.out.println("Prodotto:" + value.getNome());
        });

        // 3. Calcolare il prezzo medio di tutti i prodotti.
        double mediaPrezzo = prodotti.stream().mapToDouble(Prodotto::getPrezzo).average().orElse(0.0);
        System.out.println("Prezzo medio prodotti: " + mediaPrezzo);

        // 4. Creare una mappa dove la chiave è la categoria e il valore è una lista dei
        // nomi dei prodotti in quella categoria.
        Map<String, List<String>> catNomi = prodotti.stream()
                .collect(Collectors.groupingBy(Prodotto::getCategoria,
                        Collectors.mapping(Prodotto::getNome, Collectors.toList())));
        System.out.println("Nomi e categorie raggruppati: ");
        catNomi.forEach((key, value) -> {
            System.out.println("Categoria: " + key);
            System.out.println("Prodotti: " + value.toString());
        });
    }
}