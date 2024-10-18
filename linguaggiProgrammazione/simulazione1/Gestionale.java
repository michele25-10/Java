package linguaggiProgrammazione.simulazione1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Gestionale {
    public static void main(String[] args) {
        // Initialize ArrayList dati;
        ArrayList<Socio> sociList = new ArrayList<Socio>();
        ArrayList<Tennis> tennisList = new ArrayList<Tennis>();
        ArrayList<Squash> squashList = new ArrayList<Squash>();

        // lettura da file campi.txt
        try (FileReader f = new FileReader("campi.txt"); BufferedReader reader = new BufferedReader(f);) {
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();
            String thirdLine = reader.readLine();

            while (firstLine != null && secondLine != null && thirdLine != null) {
                String[] firstSplit = firstLine.split(" "); // codice e tipo sport
                String[] thirdSplit = thirdLine.split(" "); // almeno larghezza, lunghezza

                if (firstSplit[1] == Tennis.nomeSport) {
                    String fourLine = reader.readLine();
                    String fiveLine = reader.readLine();
                    try {
                        int codice = Integer.parseInt(firstSplit[0]);
                        float larghezza = Float.parseFloat(thirdSplit[1]);
                        float lunghezza = Float.parseFloat(thirdSplit[0]);
                        float t_media = Float.parseFloat(thirdSplit[2]);
                        float costoOrario = Float.parseFloat(fiveLine);

                        Tennis t = new Tennis(codice, secondLine, larghezza, lunghezza, t_media, fourLine, costoOrario);

                        tennisList.add(t);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
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

                        squashList.add(s);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
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
                    System.err.println(e.getMessage());
                }

                firstLine = reader.readLine();
                secondLine = reader.readLine();
                thirdLine = reader.readLine();
                fourthLine = reader.readLine();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
