
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Dipendenti {
    private String nome;
    private String dipartimento;
    private String appartenenza;
    private double stipendio;

    public Dipendenti(String nome, String dipartimento, String appartenenza, double stipendio) {
        this.nome = nome;
        this.dipartimento = dipartimento;
        this.appartenenza = appartenenza;
        this.stipendio = stipendio;
    }

    public String getNome() {
        return nome;
    }

    public String getDipartimento() {
        return dipartimento;
    }

    public String getAppartenenza() {
        return appartenenza;
    }

    public double getStipendio() {
        return stipendio;
    }
}

class Prodotto {
    private String nome;
    private String categoria;
    private double prezzo;

    public Prodotto(String nome, String categoria, Double prezzo) {
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrezzo() {
        return prezzo;
    }
}

class Studente {
    private String nome, materia;
    private int voto;

    public Studente(String nome, String materia, int voto) {
        this.nome = nome;
        this.materia = materia;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public String getMateria() {
        return materia;
    }

    public int getVoto() {
        return voto;
    }

    public String toString() {
        return nome + " " + materia + " " + voto;
    }
}

public class Tutorato {
    public static void main(String[] args) {

        // 1. Filtrare solo i numeri pari e raccoglierli in una nuova lista
        List<Integer> listInteri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numeriPari = listInteri.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("\n\nNumeri pari: ");
        numeriPari.forEach(item -> System.out.println(item));

        // 2. Filtrare solo le liste delle stringhe
        List<String> listStringhe = Arrays.asList("askjndaskj", "asdnadj", "aoqplklm", "salk", "mkslamd");
        List<String> listStringheToUpper = listStringhe.stream().map(str -> str.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("\n\nStringhe to upper: ");
        listStringheToUpper.forEach(item -> System.out.println(item));

        // 3. Data una lista di numeri calcolare la somma di tutti i numeri
        int sumNumeri = listInteri.stream().mapToInt(t -> t).sum();
        System.out.println("\n\nSomma di tutti i numeri: " + sumNumeri);

        // 4. Data una lista di stringhe contare quante stringhe hanno una lunghezza
        // superiore a 4
        long nStrOver4Char = listStringhe.stream().filter(str -> str.length() > 4).count();
        System.out.println("\n\nNumero di stringhe con più di 4 caratteri: " + nStrOver4Char);

        // 5. Data una lista di numeri, trovare il massimo e il minimo
        int maxN = listInteri.stream().mapToInt(n -> n).max().orElse(0);
        int minN = listInteri.stream().mapToInt(n -> n).min().orElse(0);
        System.out.println("\n\nNumero di minimo" + minN + " e numero massimo:  " + maxN);

        // 6. Lista di dipendenti raggruppare i dipendenti per dipartimento e calcolare
        // lo stipendio medio di ogni dipartimento
        List<Dipendenti> dipendenti = Arrays.asList(
                new Dipendenti("Mario Rossi", "Informatica", "Sede Centrale", 3000.00),
                new Dipendenti("Anna Bianchi", "Informatica", "Sede Centrale", 3200.00),
                new Dipendenti("Giovanni Verdi", "Informatica", "Filiale Nord", 3100.00),
                new Dipendenti("Sara Neri", "Amministrazione", "Sede Centrale", 2800.00),
                new Dipendenti("Luca Moretti", "Amministrazione", "Filiale Sud", 2900.00),
                new Dipendenti("Elena Gialli", "Amministrazione", "Filiale Nord", 2850.00),
                new Dipendenti("Marco Blu", "Vendite", "Sede Centrale", 2700.00),
                new Dipendenti("Claudia Viola", "Vendite", "Filiale Sud", 2600.00),
                new Dipendenti("Antonio Rosa", "Vendite", "Filiale Nord", 2750.00),
                new Dipendenti("Paola Nero", "Informatica", "Filiale Sud", 3300.00));
        Map<String, Double> stipendioMedioPerDipartimento = dipendenti.stream().collect(
                Collectors.groupingBy(Dipendenti::getDipartimento,
                        Collectors.averagingDouble(Dipendenti::getStipendio)));
        System.out.println("\n\nStipendio medio dipendenti per dipartimento: ");
        stipendioMedioPerDipartimento.forEach((key, value) -> {
            System.out.println("Dipartimento: " + key + "\t Stipendio: " + value);
        });

        // 7. Data una lista di prodotti raggruppare i prodotti per categoria e contare
        // quanti prodotti ci sono in ogni categoria
        List<Prodotto> prodotti = Arrays.asList(
                new Prodotto("Laptop", "Elettronica", 1200.50),
                new Prodotto("Smartphone", "Elettronica", 800.00),
                new Prodotto("Cuffie Bluetooth", "Elettronica", 150.00),
                new Prodotto("Frigorifero", "Elettrodomestici", 600.00),
                new Prodotto("Lavatrice", "Elettrodomestici", 450.00),
                new Prodotto("Forno a Microonde", "Elettrodomestici", 200.00),
                new Prodotto("Pane Integrale", "Alimentari", 3.50),
                new Prodotto("Latte", "Alimentari", 1.20),
                new Prodotto("Pasta", "Alimentari", 2.00),
                new Prodotto("Scarpe da Ginnastica", "Abbigliamento", 75.00));
        Map<String, Long> nProdPerCategoria = prodotti.stream().collect(
                Collectors.groupingBy(Prodotto::getCategoria,
                        Collectors.mapping(Prodotto::getNome, Collectors.counting())));
        System.out.println("\n\nNumero prodotti per categoria: ");
        nProdPerCategoria.forEach((key, value) -> {
            System.out.println("Categoria: " + key + "\t Numero prodotti: " + value);
        });

        // 8. Data una lista di studenti, raggruppare gli studenti per materia e poi per
        // fascia di voto (ALTO se il voto `e maggiore di 75, BASSO altrimenti)
        List<Studente> studenti = Arrays.asList(
                new Studente("Luca Rossi", "Matematica", 85),
                new Studente("Maria Bianchi", "Fisica", 90),
                new Studente("Giovanni Verdi", "Informatica", 78),
                new Studente("Anna Neri", "Chimica", 88),
                new Studente("Paolo Gialli", "Letteratura", 92),
                new Studente("Elena Blu", "Matematica", 95),
                new Studente("Marco Viola", "Fisica", 82),
                new Studente("Chiara Marrone", "Informatica", 89),
                new Studente("Antonio Rosa", "Chimica", 71),
                new Studente("Sara Nero", "Letteratura", 87));
        Map<String, List<Studente>> studentiPerMateria = studenti.stream().collect(
                Collectors.groupingBy(Studente::getMateria, Collectors.mapping(item -> item, Collectors.toList())));

        Map<String, List<Studente>> studentiPerFasciaVoto = studenti.stream().collect(
                Collectors.groupingBy(studente -> studente.getVoto() > 75 ? "Alto" : "Basso",
                        Collectors.mapping(item -> item, Collectors.toList())));

        System.out.println("\n\nStudenti per materia: ");
        studentiPerMateria.forEach((key, value) -> {
            System.out.println("Materia: " + key);
            value.forEach((item) -> System.out.println(item));
        });

        System.out.println("\n\nStudenti per voto: ");
        studentiPerFasciaVoto.forEach((key, value) -> {
            System.out.println("Voto: " + key);
            value.forEach((item) -> System.out.println(item));
        });
    }
}
