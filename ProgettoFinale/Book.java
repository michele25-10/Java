import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Book {

    private String ISBN, title, author, type;
    private int publicationYear;

    public Book(String ISBN, String title, String author, int publicationYear, String type) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.type = type;
    }

    public boolean insertBook() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file/Books.txt", true))) {
            writer.write(ISBN + ", " + title + ", " + author + ", " + publicationYear + ", " + type);
            writer.newLine(); // Aggiungi una nuova linea
            return false;
        } catch (IOException e) {
            e.printStackTrace(); // Gestione dell'eccezione
            return true;
        }
    }
}
