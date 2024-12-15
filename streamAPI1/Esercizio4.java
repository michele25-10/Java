package streamAPI1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double price;

    public Book(String title, String author, int publicationYear, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + "), $" + price;
    }
}

public class Esercizio4 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();

        // Aggiunta di libri alla lista
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 10.99));
        books.add(new Book("1984", "George Orwell", 1949, 8.99));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 12.50));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 14.75));
        books.add(new Book("Moby Dick", "Herman Melville", 1851, 9.99));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 11.99));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932, 13.45));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 20.99));
        books.add(new Book("Animal Farm", "George Orwell", 1949, 15.99));

        // 1. Filtro libri pubblicati dopo il 2010
        List<Book> after2010 = books.stream().filter(b -> b.getPublicationYear() > 2010).collect(Collectors.toList());
        System.out.println("Libri pubblicati dopo il 2010: ");
        for (Book b : after2010) {
            System.out.println(b.toString());
        }

        // 2. Ordinamento per pezzo: ordina la lista di libri in ordine crescente di
        // prezzo
        List<Book> bookOrderPrice = books.stream().sorted(Comparator.comparing(Book::getPrice))
                .collect(Collectors.toList());
        System.out.println("\n\nOrdinati per ordine di prezzo: ");
        for (Book b : bookOrderPrice) {
            System.out.println(b.toString());
        }

        // 3. Titoli di autori specifici
        List<Book> georgOrwellBooks = books.stream().filter(b -> b.getAuthor().equals("George Orwell"))
                .collect(Collectors.toList());
        System.out.println("\n\nTitoli di George Orwell ");
        for (Book b : georgOrwellBooks) {
            System.out.println(b.toString());
        }

        // 4. Calcola la media dei prezzi di tutti i libri
        Double averagePrice = books.stream().mapToDouble(Book::getPrice).average().orElse(0);
        System.out.println("\n\nPrezzo medio dei libri: " + averagePrice);

        // 5. libro più costoso
        Book higherPriceBook = books.stream().max(Comparator.comparing(Book::getPrice)).orElse(null);
        System.out.println("\n\nLibro più costoso: " + higherPriceBook);

        // 6. Verifica se c'è almeno un libro che costa più di 30 euro
        long countPriceOver30 = books.stream().filter(p -> p.getPrice() > 30).count();
        System.out.println("\n\nNumero libri sopra i 30 euro: " + countPriceOver30);

        // 7. Libri ordinati per anno di pubblicazione in ordine decrescente
        List<Book> orderByPubblicationYear = books.stream()
                .sorted(Comparator.comparing(Book::getPublicationYear, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("\n\nLibri ordinati per anno di pubblicazione in ordine decrescente: ");
        for (Book b : orderByPubblicationYear) {
            System.out.println(b.toString());
        }

    }
}
