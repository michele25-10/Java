import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String name, surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public boolean insertUser() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file/Users.txt", true))) {
            writer.write(name + ", " + surname);
            writer.newLine(); // Aggiungi una nuova linea
            return false;
        } catch (IOException e) {
            e.printStackTrace(); // Gestione dell'eccezione
            return true;
        }
    }
}
