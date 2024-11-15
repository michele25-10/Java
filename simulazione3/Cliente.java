package linguaggiProgrammazione.simulazione3;

import java.util.*;

public class Cliente {
    private int codice;
    private String nome;
    private List<Servizio> servizi;

    public Cliente(int codice, String nome) {
        this.codice = codice;
        this.nome = nome;
        servizi = new LinkedList<Servizio>();
    }

    public void addServizio(Servizio s) {
        servizi.add(s);
    }

    public double prezzoTotaleServizi() {
        double tot = 0;
        for (Servizio s : this.servizi) {
            tot += s.getPrezzoServizio();
        }
        return tot;
    }

    public String toString() {
        double total = prezzoTotaleServizi();
        return this.codice + "\t" + this.nome + "\t" + total;
    }

}
