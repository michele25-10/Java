import java.util.*;
import java.util.stream.Collectors;
import java.time.*;

public class Esercizio6 {
    public static void main(String[] args) {
        List<Transazione> transazioni = Arrays.asList(
                new Transazione(LocalDate.of(2023, Month.NOVEMBER, 15), 100.0, "credito"),
                new Transazione(LocalDate.of(2023, Month.APRIL, 11), 200.0, "debito"),
                new Transazione(LocalDate.of(2023, Month.AUGUST, 9), 300.0, "credito"),
                new Transazione(LocalDate.of(2023, Month.OCTOBER, 2), 400.0, "debito"),
                new Transazione(LocalDate.of(2023, Month.NOVEMBER, 8), 500.0, "credito"));

        // Punto 1: filtrare le transazioni effettuate in un determinato mese dell'anno
        List<Transazione> OctTrans = transazioni.stream()
                .filter(transizione -> transizione.getData().getMonth() == Month.OCTOBER)
                .collect(Collectors.toList());

        System.out.println(OctTrans.size());

        // Punto 2: Calcolare l'importo totale dei crediti e dei debiti separatamente
        double totalCredito = transazioni.stream().filter(transizione -> transizione.getTipo().equals("credito"))
                .mapToDouble(Transazione::getImporto).sum();

        double totalDebito = transazioni.stream().filter(transizione -> transizione.getTipo().equals("debito"))
                .mapToDouble(Transazione::getImporto).sum();

        System.out.println(totalCredito + " " + totalDebito);

        // Punto 3: Trovare la transazione con l'importo più alto in valore assoluto
        // (crediti e debiti)
        double maxTrans = transazioni.stream().mapToDouble(Transazione::getImporto).map(Math::abs).max().orElse(0.0);
        System.out.println("Valore massimo transazione: " + maxTrans);

        // Punto 4: Ordinare le transazioni in base alla data in ordine cronologico
        List<Transazione> sortTrans = transazioni.stream().sorted(Comparator.comparing(Transazione::getData))
                .collect(Collectors.toList());
        System.out.println("LISTA ORDINATA IN ORDINE CRONOLOGICO");
        for (Transazione transazione : sortTrans) {
            System.out.println(transazione.toString());
        }
    }
}