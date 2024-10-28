package linguaggiProgrammazione.simulazione38;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Gestionale {

    static List<Veicolo> veicoli = new LinkedList<Veicolo>();
    static List<Cliente> clienti = new LinkedList<Cliente>();
    static Map<Integer, Integer> noleggi = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("veicoli.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String marca = reader.readLine();
                noleggi.put(codice, 0);

                if (tipo.equals("roulotte")) {
                    tok = new StringTokenizer(reader.readLine());
                    int peso = Integer.parseInt(tok.nextToken());
                    float lunghezza = Float.parseFloat(tok.nextToken());
                    float larghezza = Float.parseFloat(tok.nextToken());
                    int numeroPosti = Integer.parseInt(tok.nextToken());
                    tok = new StringTokenizer(reader.readLine());
                    boolean veranda = tok.nextToken().equals("si") ? true : false;
                    float costoGiornaliero = Float.parseFloat(tok.nextToken());

                    Roulette r = new Roulette(codice, marca, peso, lunghezza, larghezza, numeroPosti, veranda,
                            costoGiornaliero);
                    veicoli.add(r);
                } else {
                    tok = new StringTokenizer(reader.readLine());
                    float larghezza = Float.parseFloat(tok.nextToken());
                    float lunghezza = Float.parseFloat(tok.nextToken());
                    int potenza = Integer.parseInt(tok.nextToken());
                    int postiLetto = Integer.parseInt(tok.nextToken());
                    float costoGiornaliero = Float.parseFloat(tok.nextToken());

                    Caravan c = new Caravan(codice, marca, larghezza, lunghezza, potenza, postiLetto, costoGiornaliero);
                    veicoli.add(c);
                }

                reader.readLine();
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("clienti.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer tok;
                int codice = Integer.parseInt(line);
                String nome = reader.readLine();
                String cognome = reader.readLine();
                String indirizzo = reader.readLine();

                Cliente c = new Cliente(codice, nome, cognome, indirizzo);
                clienti.add(c);

                line = reader.readLine();
                while (!line.trim().isEmpty()) {
                    tok = new StringTokenizer(line);
                    int codiceVeicolo = Integer.parseInt(tok.nextToken());
                    int numeroGiorni = Integer.parseInt(tok.nextToken());
                    c.addNoleggio(codiceVeicolo, numeroGiorni);

                    noleggi.put(codice, noleggi.get(codice) + numeroGiorni);
                    line = reader.readLine();
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println("\n\ntipo, codice, marca, larghezza, lunghezza, posti letto, peso,\r\n" + //
                "veranda, potenza, costo");
        for (Veicolo v : veicoli) {
            System.out.println(v);
        }

        System.out.println("\n\ncodice, cognome, nome, indirizzo, prenotazioni");
        for (Cliente c : clienti) {
            System.out.println(c.toString());
        }

        for (Veicolo v : veicoli) {
            int codice = v.getCodice();
            float costoGiornaliero = v.getCostoGiornaliero();

            float total = noleggi.get(codice) * costoGiornaliero;
            System.out.println(v.getMarca() + ": " + total);
        }

    }
}
