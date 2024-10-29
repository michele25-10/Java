import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Gestione {
    static List<Squadra> squadre = new LinkedList<Squadra>();
    static List<Giocatore> giocatori = new LinkedList<Giocatore>();
    static Map<Integer, Squadra> codSquadra = new HashMap<Integer, Squadra>();

    public static void main(String[] args) {
        // 1 Lettura del file squadre
        try {
            BufferedReader reader = new BufferedReader(new FileReader("squadre.txt"));
            String line = reader.readLine();
            StringTokenizer tok;
            while (line != null) {
                tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String nome = reader.readLine();
                tok = new StringTokenizer(reader.readLine());
                int nVinte = Integer.parseInt(tok.nextToken());
                int nPerse = Integer.parseInt(tok.nextToken());
                double nMedioGoal = Double.parseDouble(tok.nextToken());
                if (tipo.equals("hockey")) {
                    double nMedioFalli = Double.parseDouble(tok.nextToken());

                    Hockey h = new Hockey(codice, nome, nVinte, nPerse, nMedioGoal, nMedioFalli);
                    squadre.add(h);
                    codSquadra.put(codice, h);
                } else {
                    Pallamano p = new Pallamano(codice, nome, nVinte, nPerse, nMedioGoal);
                    squadre.add(p);
                    codSquadra.put(codice, p);
                }
                line = reader.readLine();
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        // 2 lettura file giocatori
        try {
            BufferedReader reader = new BufferedReader(new FileReader("giocatori.txt"));
            String line = reader.readLine();
            StringTokenizer tok;
            while (line != null) {
                tok = new StringTokenizer(line);
                int codiceSquadra = Integer.parseInt(tok.nextToken());
                String cognome = reader.readLine();
                String nome = reader.readLine();
                tok = new StringTokenizer(reader.readLine());
                int eta = Integer.parseInt(tok.nextToken());
                int numeroMaglia = Integer.parseInt(tok.nextToken());
                String ruolo = tok.nextToken();
                boolean titolare = Boolean.parseBoolean(tok.nextToken());

                Giocatore g = new Giocatore(codiceSquadra, cognome, nome, eta, numeroMaglia, ruolo, titolare);
                giocatori.add(g);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        // 3. Stampa delle squadre
        System.out.println("\n\nnome della squadra, codice, n. partite vinte, n. partite perse,\r\n" + //
                "n. medio di gol, n. medio di falli, n. medio di reti, sport\r");
        for (Squadra s : squadre) {
            System.out.println(s);
        }

        // 4. Stampa dei giocatori
        System.out.println("\n\nnome, cognome, età, numero di maglia, ruolo, titolare, nome\r\n" + //
                "squadra \r");
        for (Giocatore g : giocatori) {
            System.out.println(g);
        }

        // 5 Calcolo della media di partite vinte e perse per sport
        double nPartiteVinteHockey = 0;
        int squadreHockey = 0;
        double nPartiteVintePallamano = 0;
        int squadrePallamano = 0;
        for (Squadra s : squadre) {
            if (s instanceof Hockey) {
                squadreHockey++;
                nPartiteVinteHockey += s.getNumeroVittorie();
            } else {
                squadrePallamano++;
                nPartiteVintePallamano += s.getNumeroVittorie();
            }
        }

        System.out.println("\n\nMedia partite vinte squadre hockey: " + (nPartiteVinteHockey / squadreHockey));
        System.out.println("Media partite vinte squadre pallamano: " + (nPartiteVintePallamano / squadrePallamano));
    }
}
