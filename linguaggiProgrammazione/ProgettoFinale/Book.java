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
}
