package simulazione24;

import java.util.*;
import java.io.*;

public class Gestione {
    static List<Progetto> progetti = new LinkedList<Progetto>();
    static List<Ricercatore> ricercatori = new LinkedList<Ricercatore>();
    static Map<Integer, Progetto> codProgetto = new HashMap<Integer, Progetto>();

    public static void main(String[] args) {
        // 1. lettura file progetti.txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader("progetti.txt"));
            String line = reader.readLine();
            StringTokenizer tok;
            while (line != null) {
                tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String titolo = reader.readLine();
                tok = new StringTokenizer(reader.readLine());
                String nome = tok.nextToken();
                String cognome = tok.nextToken();
                String organizzazione = reader.readLine();

                if (tipo.equals("ricerca")) {
                    tok = new StringTokenizer(reader.readLine());
                    String codiceArgomento = tok.nextToken();
                    int numeroPartner = Integer.parseInt(tok.nextToken());
                    double importo = Double.parseDouble(reader.readLine());

                    Ricerca r = new Ricerca(codice, titolo, nome, cognome, organizzazione, codiceArgomento,
                            numeroPartner, importo);
                    progetti.add(r);
                    codProgetto.put(codice, r);
                } else {
                    tok = new StringTokenizer(reader.readLine());
                    int numeroPartner = Integer.parseInt(tok.nextToken());
                    double importo = Double.parseDouble(tok.nextToken());

                    Innovazione i = new Innovazione(codice, titolo, cognome, cognome, organizzazione, nome,
                            numeroPartner, importo);

                    progetti.add(i);
                    codProgetto.put(codice, i);
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        // 2. lettura file ricercatori.txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ricercatori.txt"));
            String line = reader.readLine();
            StringTokenizer tok;
            while (line != null) {
                String nome = line;
                String cognome = reader.readLine();

                Ricercatore r = new Ricercatore(nome, cognome);

                line = reader.readLine();
                while (line != null && !line.equals("")) {
                    tok = new StringTokenizer(line);
                    int codiceProgetto = Integer.parseInt(tok.nextToken());
                    double impegnoOrario = Double.parseDouble(tok.nextToken());

                    r.addImpegno(codiceProgetto, impegnoOrario);

                    line = reader.readLine();
                }

                ricercatori.add(r);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        // 3. Stampa dei progetti
        System.out.println("\n\ntipo, titolo, codice, coordinatore, organizzazione, argomento,\r\n" + //
                "partner, aziende, importo totale in migliaia di euro");
        for (Progetto p : progetti) {
            System.out.println(p);
        }

        // 4. Stampa dei ricercatori
        System.out.println("\n\nNome, cognome, impegnoOrario, lista impegni");
        for (Ricercatore r : ricercatori) {
            System.out.println(r);
        }

        // 5
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        String cognome = scanner.nextLine();
        scanner.close();
        for (Ricercatore r : ricercatori) {
            if (r.getCognome().equals(cognome)) {
                System.out.println(r.getNome() + "\t" + r.getNome() + "\t" + r.ricercaImpegnoPiuAlto());
            }
        }

    }
}
