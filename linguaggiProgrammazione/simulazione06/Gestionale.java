package linguaggiProgrammazione.simulazione06;

import java.util.*;
import java.io.*;

public class Gestionale {
    static List<Partita> partite = new LinkedList<Partita>();
    static int nFuoriCasa = 0;
    static int nCasa = 0;
    static int vinteCasa = 0;
    static int vinteFuoriCasa = 0;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("partite.txt"));) {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);

                String tipo = tok.nextToken();
                String nomePalazzetto = "";
                String nomeCitta = "";

                if (tipo.equals("c")) {
                    nomePalazzetto = tok.nextToken();
                } else {
                    nomeCitta = tok.nextToken();
                }

                String data = tok.nextToken();
                String ora = tok.nextToken();
                String risultato = tok.nextToken();
                int vinto = Integer.parseInt(tok.nextToken());

                if (tipo.equals("c")) {
                    Casa c = new Casa(nomePalazzetto, data, ora, risultato, vinto);
                    partite.add(c);
                    nCasa++;
                    if (vinto == 1) {
                        vinteCasa++;
                    }
                } else {
                    FuoriCasa fc = new FuoriCasa(nomeCitta, data, ora, risultato, vinto);
                    partite.add(fc);
                    nFuoriCasa++;
                    if (vinto == 1) {
                        vinteFuoriCasa++;
                    }
                }

                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println("Palazzetto\tCittà\tData\tOra\tRisultato\t");
        for (Partita p : partite) {
            System.out.println(p);
        }

        System.out.println("\n\nPartite in casa  " + nCasa + " di cui vinte: " + vinteCasa);
        System.out.println("Partite fuori casa " + nFuoriCasa + " di cui vinte: " + vinteFuoriCasa);

        System.out.println("\n");

        Scanner scanner = new Scanner(System.in);
        String tst = scanner.nextLine();
        boolean found = false;
        for (Partita p : partite) {
            if (p.getNomeCitta().equals(tst)) {
                System.out.println(p);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Partita non ancora gioncata");
        }
        scanner.close();
    }
}
