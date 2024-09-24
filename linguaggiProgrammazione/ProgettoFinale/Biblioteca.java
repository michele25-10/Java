import java.sql.Date;

class Biblioteca {

    public static void main(String... newyearargs) // main() method
    {
        Book book = new Book("psadasdasd", "prova inserimento", "io", 2022, "genere");
        if (book.insertBook()) {
            System.out.println("Errore");
        }

        User u = new User("Pietro", "Garibaldi");
        if (u.insertUser()) {
            System.out.println("Errore utente");
        }

        Loan l = new Loan("sjnakjsdnasd", "Michele", "Gabrieli", new Date(2024 - 10 - 20), new Date(2025 - 10 - 1));
        l.insertLoan();

        u.updateUser("Francesco", "Garibaldini");
    }
}