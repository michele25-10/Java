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
}
