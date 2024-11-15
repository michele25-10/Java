package linguaggiProgrammazione.simulazione3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Gestionale {
    static List<Dipendente> dipendenti = new LinkedList<Dipendente>();
    static List<Cliente> clienti = new LinkedList<Cliente>();
    static Map<Integer, Dipendente> codDip = new HashMap<Integer, Dipendente>();
    static Map<Integer, Integer> dipNServizi = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("dipendenti.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String nome = reader.readLine();
                tok = new StringTokenizer(reader.readLine());
                if (tipo.equals("trainer")) {
                    int oreSettimanali = Integer.parseInt(tok.nextToken());
                    double costoOrario = Double.parseDouble(tok.nextToken());
                    String specialita = reader.readLine();

                    Trainer t = new Trainer(codice, nome, oreSettimanali, costoOrario, specialita);
                    dipendenti.add(t);
                    codDip.put(codice, t);
                } else {
                    int telefono = Integer.parseInt(tok.nextToken());
                    boolean medico = Boolean.parseBoolean(tok.nextToken());
                    int appuntamentiSettimanali = Integer.parseInt(tok.nextToken());
                    double costoOrario = Double.parseDouble(tok.nextToken());

                    Nutrizionista n = new Nutrizionista(codice, nome, telefono, medico, appuntamentiSettimanali,
                            costoOrario);
                    dipendenti.add(n);
                    codDip.put(codice, n);
                }
                dipNServizi.put(codice, 0);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        try (BufferedReader reader = new BufferedReader((new FileReader("clienti.txt")))) {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);

                int codice = Integer.parseInt(tok.nextToken());
                String nome = reader.readLine();
                Cliente c = new Cliente(codice, nome);
                clienti.add(c);
                line = reader.readLine();
                while (!line.trim().isEmpty()) {
                    tok = new StringTokenizer(line);

                    int codiceDipendente = Integer.parseInt(tok.nextToken());
                    double numeroOre = Double.parseDouble(tok.nextToken());

                    Servizio s = new Servizio(codiceDipendente, numeroOre);
                    c.addServizio(s);
                    dipNServizi.put(codiceDipendente, dipNServizi.get(codiceDipendente) + 1);

                    line = reader.readLine();
                }
                line = reader.readLine();
            }
            System.err.println(line);
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        // 3
        System.out
                .println("nome, codice, tipo, ore settimanali, specialità, telefono, medico, app.sett., costo orario");
        for (Dipendente d : dipendenti) {
            System.out.println(d.toString());
        }

        // 4
        System.out.println("\n\nnome, codice, costoTotServizi");
        for (Cliente c : clienti) {
            System.out.println(c.toString());
        }

        System.out.println("\n\nDipendente che ha svolto più servizi: ");
        String nomeMax = "";
        int tmp = 0;
        for (Dipendente d : dipendenti) {
            if (dipNServizi.get(d.getCodice()) > tmp) {
                tmp = dipNServizi.get(d.getCodice());
                nomeMax = d.getNome();
            }
        }
        System.out.println(nomeMax + " " + tmp);

    }

}
