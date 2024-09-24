import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class Loan {
    private String ISBN, name, surname;
    private Date start, finish;

    public Loan(String ISBN, String name, String surname, Date start, Date finish) {
        this.ISBN = ISBN;
        this.name = name;
        this.surname = surname;
        this.start = start;
        this.finish = finish;
    }

    public boolean insertLoan() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file/Loans.txt", true))) {
            writer.write(ISBN + ", " + name + ", " + surname + ", " + start + ", " + finish);
            writer.newLine(); // Aggiungi una nuova linea
            return false;
        } catch (IOException e) {
            e.printStackTrace(); // Gestione dell'eccezione
            return true;
        }
    }
}
