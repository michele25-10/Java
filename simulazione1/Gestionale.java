//package linguaggiProgrammazione.simulazione1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Gestionale {
    public static void main(String[] args) {
        // Initialize ArrayList dati;
        ArrayList<Socio> sociList = new ArrayList<Socio>();
        ArrayList<Sport> sportList = new ArrayList<Sport>();

        // lettura da file campi.txt
        try (FileReader f = new FileReader("campi.txt"); BufferedReader reader = new BufferedReader(f);) {
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();
            String thirdLine = reader.readLine();
            while (firstLine != null && secondLine != null && thirdLine != null) {
                String[] firstSplit = firstLine.split(" "); // codice e tipo sport
                String[] thirdSplit = thirdLine.split(" "); // almeno larghezza, lunghezza
                System.out.println(
                        firstSplit[1] + " == " + Tennis.nomeSport + " -> " + firstSplit[1] == Tennis.nomeSport);
                if (firstSplit[1].equals(Tennis.nomeSport)) {
                    String fourLine = reader.readLine();
                    String fiveLine = reader.readLine();

                    try {
                        int codice = Integer.parseInt(firstSplit[0]);
                        float larghezza = Float.parseFloat(thirdSplit[1]);
                        float lunghezza = Float.parseFloat(thirdSplit[0]);
                        float t_media = Float.parseFloat(thirdSplit[2]);
                        float costoOrario = Float.parseFloat(fiveLine);

                        Tennis t = new Tennis(codice, secondLine, larghezza, lunghezza, t_media, fourLine, costoOrario);

                        sportList.add(t);
                    } catch (Exception e) {
                        System.out.println("Errore conversione: " + e);
                    }

                } else {
                    try {
                        int codice = Integer.parseInt(firstSplit[0]);
                        float larghezza = Float.parseFloat(thirdSplit[1]);
                        float lunghezza = Float.parseFloat(thirdSplit[0]);
                        float altezza = Float.parseFloat(thirdSplit[2]);
                        int piano = Integer.parseInt(thirdSplit[3]);
                        float costoOrario = Float.parseFloat(thirdSplit[4]);

                        Squash s = new Squash(codice, secondLine, larghezza, lunghezza, altezza, piano, costoOrario);

                        sportList.add(s);
                    } catch (Exception e) {
                        System.out.println("Errore conversione: " + e.getMessage());
                    }
                }

                firstLine = reader.readLine();
                secondLine = reader.readLine();
                thirdLine = reader.readLine();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // lettura da file giocatori.txt
        try (FileReader f = new FileReader("giocatori.txt"); BufferedReader reader = new BufferedReader(f);) {
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();
            String thirdLine = reader.readLine();
            String fourthLine = reader.readLine();

            while (firstLine != null && secondLine != null && thirdLine != null && fourthLine != null) {
                String[] thirdSplit = thirdLine.split(" ");
                String[] fourthSplit = fourthLine.split(" ");
                try {
                    int codice = Integer.parseInt(firstLine);
                    int eta = Integer.parseInt(thirdSplit[0]);
                    int categoria = Integer.parseInt(thirdSplit[1]);
                    Socio s = new Socio(codice, secondLine, eta, categoria);

                    for (int i = 0; i < fourthSplit.length; i = i + 2) {
                        int codicePrenotazione = Integer.parseInt(fourthSplit[i]);
                        int oraInizio = Integer.parseInt(fourthSplit[i + 1]);
                        s.addPrenotazione(codicePrenotazione, oraInizio);
                    }

                    sociList.add(s);

                } catch (Exception e) {
                    System.err.println("Errore conversione:" + e.getMessage());
                }

                firstLine = reader.readLine();
                secondLine = reader.readLine();
                thirdLine = reader.readLine();
                fourthLine = reader.readLine();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Stampa a schermo del contenuto dei file
        System.out.println("STAMPA DEGLI SPORT");
        sportList.forEach(item -> {
            System.out.println(item.toString());
        });

        // Stampa a schermo del contenuto dei file
        System.out.println("\n\nSTAMPA DEI SOCI");
        sociList.forEach(item -> {
            System.out.println(item.toString());
        });

        // lettura da tastiera
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Inserisci i codici dei campi che ti interessano (digita 'q' per uscire):");

        // Continua a leggere finché l'utente non inserisce 'q'
        while (true) {
            input = scanner.nextLine(); // Legge una linea di input
            try {
                if (input.equals("q")) {
                    // Se l'input è 'q', esci dal ciclo
                    System.out.println("Carattere di fine inserito. Uscita.");
                    break;
                }

                int codice_campo = Integer.parseInt(input);

                float[] costo_orario = { 0 };
                sportList.forEach(item -> {
                    if (codice_campo == item.getCodice()) {
                        costo_orario[0] = item.getCostoOrario();
                    }
                });

                final float[] total = { 0 };
                sociList.forEach(item -> {
                    total[0] += item.costoPrenotazioneCampo(codice_campo, costo_orario[0]);
                });

                System.out.println("\nTotale profitto del campo con codice " + codice_campo + ": " + total[0]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close(); // Chiudi lo scanner
    }

}
