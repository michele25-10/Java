package lab25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Esempio {
    public static void main(String[] args) {
        List<Persona> persone = Arrays.asList(
                new Persona("Mario", "Bros", 30, Arrays.asList("calcio", "lettura")),
                new Persona("Stefano", "Girilli", 52, Arrays.asList("lettura")),
                new Persona("Sofia", "Crisa", 20, Arrays.asList("as", "Social")),
                new Persona("Gaia", "Clerici", 21, Arrays.asList("sasd", "sad")),
                new Persona("Tony", "Effe", 33, Arrays.asList("as", "sa")),
                new Persona("Franco", "Grosso", 48, Arrays.asList("Lettura")));

        Map<String, List<Persona>> personePerPassione = persone.stream()
                .filter(p -> p.getEta() >= 18) // Filtra i maggiorenni
                .sorted(Comparator.comparing(Persona::getEta))
                .collect(Collectors.groupingBy(p -> p.getPassioni().get(0)));
    }
}
