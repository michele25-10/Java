import java.util.*; 

public class Cliente {
    private int codice; 
    private String nome, cognome, indirizzo; 
    private List<Noleggio> noleggi; 

    public Cliente(int codice, String nome, String cognome, String indirizzo ){
        this.codice = codice; 
        this.nome = nome; 
        this.cognome = cognome; 
        this.indirizzo = indirizzo; 
        this.noleggi = new LinkedList<Noleggio>(); 
    }

    public void addNoleggio(int codiceVeicolo, int numeroGiorni){
        this.noleggi.add(new Noleggio(codiceVeicolo, numeroGiorni)); 
    }

    public String toString(){
        StringBuffer listNoleggi = new StringBuffer(); 
        for(Noleggio n: this.noleggi){
            listNoleggi.append(n.toString()); 
        }
        return this.codice + "\t" + this.cognome + "\t" + this.nome + "\t" + this.indirizzo + "\t" + listNoleggi.toString(); 
    }

}
