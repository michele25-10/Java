package linguaggiProgrammazione.simulazione20;

import java.util.*;
import java.io.*;

public class Gestionale {
    static List<Iscritto> iscritti = new LinkedList<Iscritto>();
    static List<Seguono> seguiti = new LinkedList<Seguono>();
    static Map<Integer, Iscritto> codIscritto = new HashMap<Integer, Iscritto>();
    static Map<Integer, Integer> seguaci = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("iscritti.txt"))) {
            String line = reader.readLine();
            StringTokenizer tok;
            while (line != null) {
                tok = new StringTokenizer(line);
                String tipo = tok.nextToken();
                int codice = Integer.parseInt(tok.nextToken());
                if (tipo.equals("individuo")) {
                    tok = new StringTokenizer(reader.readLine());
                    String nome = tok.nextToken();
                    String cognome = tok.nextToken();
                    String indirizzo = reader.readLine();
                    tok = new StringTokenizer(reader.readLine());
                    String nomeAccount = tok.nextToken();
                    String password = tok.nextToken();

                    Individuo i = new Individuo(codice, nome, cognome, indirizzo, nomeAccount, password);
                    iscritti.add(i);

                    seguaci.put(codice, 0);
                    codIscritto.put(codice, i);

                } else {
                    String ragioneSociale = reader.readLine();
                    String indirizzo = reader.readLine();
                    tok = new StringTokenizer(reader.readLine());
                    String nome = tok.nextToken();
                    String cognome = tok.nextToken();
                    tok = new StringTokenizer(reader.readLine());
                    String nomeAccount = tok.nextToken();
                    String password = tok.nextToken();

                    Azienda a = new Azienda(codice, ragioneSociale, indirizzo, nome, cognome, nomeAccount, password);
                    iscritti.add(a);

                    seguaci.put(codice, 0);
                    codIscritto.put(codice, a);
                }
                reader.readLine();
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("segue.txt"))) {
            String line = reader.readLine();
            StringTokenizer tok;
            while (line != null) {
                int codiceIscritto = Integer.parseInt(line);
                Seguono s = new Seguono(codiceIscritto);

                tok = new StringTokenizer(reader.readLine());
                int n = tok.countTokens();
                int k = 0;
                while (k < n) {
                    int codSegauce = Integer.parseInt(tok.nextToken());
                    s.addIscritto(codSegauce);
                    k++;
                }

                seguiti.add(s);
                seguaci.put(codiceIscritto, n);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println("\n\nID Nome/Cognome RagioneSociale Nome/CognomeGestoreAccount Indirizzo\r\n" +
                "NomeAccount LunghezzaPassword\r");
        for (Iscritto i : iscritti) {
            System.out.println(i);
        }

        System.out.println("\n\nID Nome/Cognome/RagioneSociale NumeroSeguaci");
        for (Seguono s : seguiti) {
            System.out.println(s);
        }

        int maxSeguaci = 0;
        int tmp = 0;
        String nome = "";
        String cognome = "";
        String ragioneSociale = "";
        for (Iscritto i : iscritti) {
            tmp = seguaci.get(i.getCodice());
            if (tmp > maxSeguaci) {
                maxSeguaci = tmp;
                if (i instanceof Azienda) {
                    ragioneSociale = i.getRagioneSociale();
                    nome = "";
                    cognome = "";
                } else {
                    ragioneSociale = "";
                    nome = i.getNome();
                    cognome = i.getCognome();
                }
            }
        }

        System.out.println("\n\n" + (nome.isEmpty() && cognome.isEmpty() ? ragioneSociale : nome + " " + cognome) + ": "
                + maxSeguaci);

    }

}
