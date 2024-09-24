import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public boolean updateUser(String newName, String newSurname) {
        // Lista per conservare tutte le righe del file
        List<String> fileContent = new ArrayList<>();

        // Leggi tutte le righe dal file
        try (BufferedReader reader = new BufferedReader(new FileReader("file/Users.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Se troviamo la riga che corrisponde al nome e cognome, la modifichiamo
                if (line.trim().equals(name + ", " + surname)) {
                    fileContent.add(newName + ", " + newSurname); // Sovrascriviamo la riga
                } else {
                    fileContent.add(line); // Manteniamo le altre righe invariate
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }

        // Scrivi di nuovo il contenuto modificato nel file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file/Users.txt"))) {
            for (String line : fileContent) {
                writer.write(line);
                writer.newLine(); // Aggiungi una nuova linea dopo ogni riga
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }
}
