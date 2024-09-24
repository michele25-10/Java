class Biblioteca {

    public static void main(String... newyearargs) // main() method
    {
        Book book = new Book("psadasdasd", "prova inserimento", "io", 2022, "genere");
        if (book.insertBook()) {
            System.out.println("Errore");
        }
    }
}