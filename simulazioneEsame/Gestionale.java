import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Gestionale {
    public static void main(String[] args){
        List<Veicolo> veicoli = new LinkedList<Veicolo>(); 
        List<Cliente> clienti = new LinkedList<Cliente>(); 
        Map<Integer, Integer> codGiorni = new HashMap<Integer, Integer>(); 

        try(BufferedReader reader = new BufferedReader(new FileReader("veicoli.txt"))){
            String line = reader.readLine(); 
            StringTokenizer tok; 
            while(line!=null){  
                tok = new StringTokenizer(line); 
                int codice = Integer.parseInt(tok.nextToken()); 
                String tipo = tok.nextToken(); 
                String marcaVeicolo = reader.readLine(); 
                tok = new StringTokenizer(reader.readLine()); 
                if(tipo.equals("roulotte")){ 
                    int peso = Integer.parseInt(tok.nextToken()); 
                    float lunghezza = Float.parseFloat(tok.nextToken()); 
                    float larghezza = Float.parseFloat(tok.nextToken()); 
                    int postiLetto = Integer.parseInt(tok.nextToken()); 
                    tok = new StringTokenizer(reader.readLine()); 
                    boolean veranda = tok.nextToken().equals("si") ? true : false; 
                    float costoGiornaliero = Float.parseFloat(tok.nextToken()); 
                    
                    Roulotte r = new Roulotte(codice, marcaVeicolo, peso, lunghezza, larghezza, postiLetto, veranda, costoGiornaliero); 
                    veicoli.add(r); 
                } else {
                    float larghezza = Float.parseFloat(tok.nextToken()); 
                    float lunghezza = Float.parseFloat(tok.nextToken()); 
                    int potenza = Integer.parseInt(tok.nextToken()); 
                    int postiLetto = Integer.parseInt(tok.nextToken()); 
                    float costoGiornaliero = Float.parseFloat(tok.nextToken()); 

                    Caravan c = new Caravan(codice, marcaVeicolo, larghezza, lunghezza, potenza, postiLetto, costoGiornaliero); 
                    veicoli.add(c); 
                }

                codGiorni.put(codice, 0); 

                reader.readLine(); 
                line = reader.readLine(); 
            }
            reader.close();
        } catch(IOException e ){
            System.err.println(e);
        } catch (Exception e){
            System.err.println(e);
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("clienti.txt"))){
            String line = reader.readLine(); 
            StringTokenizer tok; 
            while(line!=null){  
                tok = new StringTokenizer(line); 
                int codice = Integer.parseInt(tok.nextToken()); 
                String nome = reader.readLine(); 
                String cognome = reader.readLine(); 
                String indirizzo = reader.readLine(); 

                Cliente c = new Cliente(codice, nome, cognome, indirizzo); 

                line = reader.readLine(); 
                while(!line.trim().isEmpty()){
                    tok = new StringTokenizer(line); 
                    int codiceVeicolo = Integer.parseInt(tok.nextToken()); 
                    int nGiorni = Integer.parseInt(tok.nextToken()); 
                    c.addNoleggio(codiceVeicolo, nGiorni);

                    codGiorni.put(codice, codGiorni.get(codice) + nGiorni); 
                    
                    line = reader.readLine(); 
                }

                clienti.add(c); 
                line = reader.readLine(); 
            }
            reader.close();
        } catch(IOException e ){
            System.err.println(e);
        } catch (Exception e){
            System.err.println(e);
        }
    
    System.out.println("\n\ntipo, codice, marca, larghezza, lunghezza, posti letto, peso,\n" + //
                "veranda, potenza, costo");
        for(Veicolo v : veicoli){
            System.out.println(v);
        }
    
        System.out.println("\n\ncodice, cognome, nome, indirizzo, prenotazioni");
        for(Cliente c : clienti){
            System.out.println(c);
        }

        System.out.println("\n\ncodice, incasso");
        for(Veicolo v : veicoli){
            int codice = v.getCodice(); 
            float incasso = codGiorni.get(codice) * v.getCostoGiornaliero(); 
            System.out.println(codice + "\t" + incasso);
        }    
    }
}
