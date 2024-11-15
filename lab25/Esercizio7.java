import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Esercizio7 {
    public static void main(String[] args) {
        List<Prodotto> prodotti = new ArrayList<>();

        prodotti.add(new Prodotto("Laptop", 1200.99, "Elettronica"));
        prodotti.add(new Prodotto("Smartphone", 799.49, "Elettronica"));
        prodotti.add(new Prodotto("Frigorifero", 499.99, "Elettrodomestici"));
        prodotti.add(new Prodotto("Tavolo", 150.00, "Arredamento"));
        prodotti.add(new Prodotto("Sedia", 75.50, "Arredamento"));
        prodotti.add(new Prodotto("Tostapane", 39.99, "Elettrodomestici"));
        prodotti.add(new Prodotto("Libri", 25.00, "Cartoleria"));
        prodotti.add(new Prodotto("Auricolari", 59.99, "Elettronica"));

        // 1. Filtrare i prodotti di una categoria specifica e con un prezzo superiore a
        // una certa soglia.
        List<Prodotto> prodFiltrati = prodotti.stream()
                .filter(prod -> prod.getCategoria().equals("Elettronica") && prod.getPrezzo() > 150)
                .collect(Collectors.toList());
        for (Prodotto p : prodFiltrati) {
            System.out.println(p);
        }
        // 2. Trovare il prodotto più caro di ogni categoria.
        prodotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria)).forEach((categoria, prod) -> {
            double maxPrezzo = prod.stream().mapToDouble(Prodotto::getPrezzo).max().orElse(0.0);
            System.out.println("Categoria: " + categoria + " --> " + maxPrezzo);
        });

        // 3. Calcolare il prezzo medio di tutti i prodotti.
        Double average = prodotti.stream().mapToDouble(Prodotto::getPrezzo).average().orElse(0.0);
        System.out.println("Media di tutti i prodotti prezzo: " + average);

        // 4.Creare una mappa dove la chiave è la categoria e il valore è una lista dei
        // nomi dei prodotti in quella categoria.
        Map<String, List<Prodotto>> mappa = prodotti.stream()
                .collect(Collectors.groupingBy(Prodotto::getCategoria));

        // Stampa la mappa
        mappa.forEach((categoria, listaProdotti) -> {
            System.out.println("Categoria: " + categoria);
            listaProdotti.forEach(System.out::println);
        });
    }
}
