package streamAPI1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.time.*;

class Transazione {
    private LocalDate data;
    private double importo;
    private String tipo;

    public Transazione

    (LocalDate data, double importo, String tipo) {

        this.data = data;

        this.importo = importo;

        this.tipo = tipo;

    }

    public LocalDate getData() {
        return data;

    }

    public double getImporto() {
        return importo;

    }

    public String getTipo() {
        return tipo;

    }

    public String toString() {
        return data + " , " + importo + " , " + tipo;

    }
}

public class Esercizio2 {
    public static void main(String[] args) {
        List<Transazione> transazioni = Arrays.asList(
                new Transazione(LocalDate.of(2023, Month.NOVEMBER, 15), 100.0, "credito"),
                new Transazione(LocalDate.of(2023, Month.APRIL, 11), 200.0, "debito"),
                new Transazione(LocalDate.of(2023, Month.AUGUST, 9), 300.0, "credito"),
                new Transazione(LocalDate.of(2023, Month.OCTOBER, 2), 400.0, "debito"),
                new Transazione(LocalDate.of(2023, Month.NOVEMBER, 8), 500.0, "credito"));

        // Punto 1: filtrare le transazioni effettuate in un determinato mese dell'anno
        List<Transazione> transNov = transazioni.stream().filter(item -> item.getData().getMonth() == Month.NOVEMBER)
                .collect(Collectors.toList());
        System.out.println("Transazioni di novembre: ");
        for (Transazione t : transNov) {
            System.out.println(t.toString());
        }

        // Punto 2: Calcolare l'importo totale dei crediti e dei debiti separatamente
        double crediti = transazioni.stream().filter(t -> t.getTipo().equals("credito"))
                .mapToDouble(Transazione::getImporto).sum();
        System.out.println("Totale crediti di novembre: " + crediti);

        double debiti = transazioni.stream().filter(t -> t.getTipo().equals("debito"))
                .mapToDouble(Transazione::getImporto).sum();
        System.out.println("Transazioni di novembre: " + debiti);
        // Punto 3: Trovare la transazione con l'importo più alto in valore
        // assoluto (crediti e debiti)
        double maxTransazione = transazioni.stream().mapToDouble(Transazione::getImporto).max().orElse(0.0);
        System.out.println("Transazione massima " + maxTransazione);

        // Punto 4: Ordinare le transazioni in base alla data in ordine cronologico
        System.out.println("Transazioni ordine cronologico:");
        List<Transazione> cronologico = transazioni.stream()
                .sorted(Comparator.comparing(Transazione::getData)).collect(Collectors.toList());
        cronologico.forEach(item -> System.out.println(item.getData()));
    }
}