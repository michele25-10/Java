import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Persona {
    private String nome, cognome;

    private int eta;
    private List<String> passioni;

    public Persona(String nome, String cognome, int eta, List<String> passioni) {

        this.nome = nome;

        this.cognome = cognome;

        this.eta = eta;
        this.passioni = passioni;

    }

    public String getNome() {
        return nome;

    }

    public String getCognome() {
        return cognome;

    }

    public int getEta() {
        return eta;

    }

    public List<String> getPassioni() {
        return passioni;

    }

    public String toString() {
        return nome + " " + cognome + " " + eta;
    }
}

public class Esercizio1 {
    public static void main(String[] args) {
        List<Persona> persone = new ArrayList<Persona>();

        persone.add(new Persona("Marco", "Rossi", 25, Arrays.asList("Calcio", "Viaggiare", "Fotografia")));
        persone.add(new Persona("Anna", "Bianchi", 30, Arrays.asList("Lettura", "Cucinare", "Yoga")));
        persone.add(new Persona("Luca", "Verdi", 20, Arrays.asList("Lettura", "Cinema", "Musica")));
        persone.add(new Persona("Giulia", "Neri", 28, Arrays.asList("Pittura", "Escursionismo", "Ballare")));
        persone.add(new Persona("Francesco", "Ferrari", 35, Arrays.asList("Scacchi", "Tennis", "Programmazione")));

        // 1. solo le persone maggiorenni
        List<Persona> maggiorenni = persone.stream().filter((item) -> (item.getEta() >= 18))
                .collect(Collectors.toList());
        System.out.println("Lista persone maggiorenni: ");
        for (Persona p : maggiorenni) {
            System.out.println(p.toString());
        }

        // 2. Ordinare le persone filtrate in base all'eta in modo crescente
        List<Persona> sortEta = maggiorenni.stream().sorted(Comparator.comparing(Persona::getEta))
                .collect(Collectors.toList());
        System.out.println("Lista persone maggiorenni ordinata: ");
        for (Persona p : sortEta) {
            System.out.println(p.toString());
        }

        // 3. Raggruppare le persone per passione
        Map<String, List<Persona>> personePerPassione = sortEta.stream()
                .collect(Collectors.groupingBy(p -> p.getPassioni().get(0)));

        // 4.Stampare per ogni passione, il numero di persone interessate e la lista
        // dei loro nomi e cognomi.
        personePerPassione.forEach((key, item) -> {
            System.out.println("Passione: " + key);
            System.out.println("Numero: " + item.size());
            item.forEach(p -> System.out.println(p.toString()));
        });
    }
}