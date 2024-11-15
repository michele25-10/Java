import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
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

        Map<String, List<Persona>> mapPeople = persone.stream().filter(p -> p.getEta() >= 18)
                .sorted(Comparator.comparing(Persona::getEta))
                .collect(Collectors.groupingBy(p -> p.getPassioni().get(0)));

        mapPeople.forEach((passione, personeConPassione) -> {
            System.out.println("Passione: " + passione);
            System.out.println("Numero persone: " + personeConPassione.size());
            OptionalDouble media = personeConPassione.stream().mapToInt(Persona::getEta).average();
            System.out.println("Media età " + media.toString());
            personeConPassione.forEach(item -> System.out.println(item.getNome() + " " + item.getCognome()));
        });
    }
}
