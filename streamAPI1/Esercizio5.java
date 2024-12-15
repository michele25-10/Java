package streamAPI1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Persona {
    private String nome;
    private int eta;
    private Genere genere;
    private String citta;

    static public enum Genere {
        MASCHIO,
        FEMMINA
    }

    public Persona(String nome, int eta, Genere genere, String citta) {
        this.nome = nome;
        this.eta = eta;
        this.genere = genere;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public Genere getGenere() {
        return genere;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                ", genere=" + genere +
                ", citta='" + citta + '\'' +
                '}';
    }

}

public class Esercizio5 {
    public static void main(String[] args) {
        // Creazione della lista di persone
        List<Persona> persone = new ArrayList<>();

        persone.add(new Persona("Mario Rossi", 25, Persona.Genere.MASCHIO, "Roma"));
        persone.add(new Persona("Anna Bianchi", 30, Persona.Genere.FEMMINA, "Milano"));
        persone.add(new Persona("Luca Verdi", 22, Persona.Genere.MASCHIO, "Napoli"));
        persone.add(new Persona("Sara Neri", 27, Persona.Genere.FEMMINA, "Torino"));
        persone.add(new Persona("Giovanni Blu", 35, Persona.Genere.MASCHIO, "Firenze"));
        persone.add(new Persona("Chiara Gialli", 28, Persona.Genere.FEMMINA, "Genova"));
        persone.add(new Persona("Marco Marrone", 40, Persona.Genere.MASCHIO, "Bologna"));
        persone.add(new Persona("Elisa Rossi", 19, Persona.Genere.FEMMINA, "Torino"));
        persone.add(new Persona("Antonio Nero", 50, Persona.Genere.MASCHIO, "Palermo"));
        persone.add(new Persona("Giulia Viola", 23, Persona.Genere.FEMMINA, "Bari"));

        // 1. filtrare le persone che hanno più di 30 anni
        List<Persona> over30 = persone.stream().filter(p -> p.getEta() > 30).collect(Collectors.toList());
        for (Persona p : over30) {
            System.out.println(p);
        }

        // 2. Estrarre i nomi delle persone che vivono in una città specifica es.
        // "Milano"
        List<String> peopleLiveInMilan = persone.stream().filter(p -> p.getCitta().equals("Milano"))
                .map(Persona::getNome)
                .collect(Collectors.toList());
        System.out.println("Nomi persone che vivono a milano:");
        for (String p : peopleLiveInMilan) {
            System.out.println(p);
        }

        // 3. Calcolare l'età media delle persone di sesso femminile
        Double averageAgeFemale = persone.stream().filter(p -> p.getGenere() == Persona.Genere.FEMMINA)
                .mapToInt(Persona::getEta).average().orElse(0);
        System.out.println("Eta media di sesso femminile: " + averageAgeFemale);

        // 4. Trovare la persona più giovane nella lista
        Persona youngestPerson = persone.stream().min(Comparator.comparing(Persona::getEta)).orElse(null);
        System.out.println("Persona più giovane: " + youngestPerson);

        // 5. Raggrupare le persone per città
        Map<String, List<Persona>> peopleGroupByCity = persone.stream()
                .collect(Collectors.groupingBy(Persona::getCitta,
                        Collectors.mapping(item -> item, Collectors.toList())));
        System.out.println("Raggrupare le persone per città: ");
        peopleGroupByCity.forEach((key, item) -> {
            System.out.println("Città: " + key);
            System.out.println("Persone: ");
            item.forEach(p -> {
                System.out.println(p);
            });
        });

        // 6. Verificare se tutte le persone della lista sono maggiorenni
        Boolean checkAllMaggiorenni = (persone.stream().filter(p -> p.getEta() > 18).count() == persone.size())
                ? true
                : false;
        System.out.println("Verificare se tutte le persone della lista sono maggiorenni: " + checkAllMaggiorenni);

        // 7. Contare quante persone vivono in una città specifica
        long peopleInMilan = persone.stream().filter(p -> p.getCitta().equals("Palermo")).count();
        System.out.println("Contare quante persone vivono in una città specifica: " + peopleInMilan);
    }
}
