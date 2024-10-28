package linguaggiProgrammazione.simulazione38;

import java.util.*;

public class Cliente {
    private int codice;
    private String nome, cognome, indirizzo;

    private List<Noleggio> noleggi;

    public Cliente(int codice, String nome, String cognome, String indirizzo) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.noleggi = new LinkedList<Noleggio>();
    }

    public void addNoleggio(int codiceVeicolo, int NumeroGiorni) {
        this.noleggi.add(new Noleggio(codiceVeicolo, NumeroGiorni));
    }

    public String toString() {
        return this.codice + "\t" + this.nome + "\t" + this.cognome + "\t" + this.indirizzo + this.noleggi.toString();
    }

}
