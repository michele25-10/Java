package linguaggiProgrammazione.exception;

public class Main {
    public static void main(String[] args) {
        try {
            new Converter(args);
        } catch (NumberFormatException e1) {
            System.out.println("Format Exception 1: " + e1.getMessage()); // Messaggio di errore predefinito
        } catch (IllegalArgumentException e2) {
            System.out.println("Format Exception 2: " + e2.getMessage()); // Messaggio di errore definito in Esercizio1
        }
    }
}
