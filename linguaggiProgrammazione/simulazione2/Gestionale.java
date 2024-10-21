//package linguaggiProgrammazione.simulazione2;

import java.io.*;
import java.util.*;

public class Gestionale {
    public static void main(String[] args) {
        List<Veicolo> veicoli = new LinkedList<Veicolo>();
        List<Cliente> clienti = new LinkedList<Cliente>();
        Map<Integer, Veicolo> codVeicolo = new HashMap<Integer, Veicolo>();
        Map<String, Veicolo> targaVeicolo = new HashMap<String, Veicolo>();

        try (BufferedReader reader = new BufferedReader(new FileReader("veicoli.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String targa = tok.nextToken();
                String modello = reader.readLine();
                String marca = reader.readLine();

                if (tipo.equals("auto")) {
                    line = reader.readLine();
                    tok = new StringTokenizer(line);
                    double dimensioneBagagliaio = Double.parseDouble(tok.nextToken());
                    int cilindrata = Integer.parseInt(tok.nextToken());
                    String categoria = reader.readLine();
                    double costoGiornaliero = Double.parseDouble(reader.readLine());
                    Auto a = new Auto(codice, targa, modello, marca, costoGiornaliero, dimensioneBagagliaio, cilindrata,
                            categoria);
                    veicoli.add(a);
                    codVeicolo.put(codice, a);
                    targaVeicolo.put(targa, a);
                } else {
                    line = reader.readLine();
                    tok = new StringTokenizer(line);
                    boolean rimorchio = Boolean.parseBoolean(tok.nextToken());
                    int numeroPosti = Integer.parseInt(tok.nextToken());
                    boolean vanoCarico = Boolean.parseBoolean(tok.nextToken());
                    double costoGiornaliero = Double.parseDouble(reader.readLine());

                    Furgone f = new Furgone(codice, targa, modello, marca, costoGiornaliero, rimorchio, numeroPosti,
                            vanoCarico);
                    veicoli.add(f);
                    codVeicolo.put(codice, f);
                    targaVeicolo.put(targa, f);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("clienti.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                String nome = tok.nextToken();
                String cognome = tok.nextToken();

                Cliente c = new Cliente(nome, cognome);
                clienti.add(c);

                line = reader.readLine();
                while (!line.trim().isEmpty()) {
                    System.err.println("SONO QUA DENTRO");
                    tok = new StringTokenizer(line);
                    int codiceVeicolo = Integer.parseInt(tok.nextToken());
                    int numeroGiorni = Integer.parseInt(tok.nextToken());

                    c.pushNoleggio(codiceVeicolo, numeroGiorni);
                    line = reader.readLine();
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e.getCause());
        }

        // 3. Stampa dei veicoli
        System.out.println("tipo, targa, codice, modello, marca, costo giornaliero,\r\n" + //
                "bagagliaio, cilindrata, categoria, rimorchio, numero di posti,\r\n" + //
                "vano di carico");
        for (Veicolo v : veicoli) {
            System.out.println(v.toString());
        }

        // 4. Stampa clienti e noleggio più costoso
        System.out.println("\n\nNome, Cognome, Noleggio più costoso, numero noleggi");
        for (Cliente c : clienti) {
            System.out.println(c.toString(codVeicolo));
        }

        // PUNTO 5: Numero di noleggi da una targa
        Scanner scanner = new Scanner(System.in);
        String tar = scanner.nextLine();
        scanner.close();
        int cod = targaVeicolo.get(tar).getCodice();
        int count = 0;
        for (Cliente c : clienti) {
            count += c.getNumNoleggi(cod);
        }
        System.out.println(count);
    }
}
