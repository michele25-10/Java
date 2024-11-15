//package linguaggiProgrammazione.simulazione2;

import java.util.*;

public class Cliente {
    private String nome, cognome;
    private List<Noleggio> noleggi;

    public Cliente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.noleggi = new LinkedList<Noleggio>();
    }

    public void pushNoleggio(int codiceVeicolo, int numeroGiorni) {
        this.noleggi.add(new Noleggio(codiceVeicolo, numeroGiorni));
    }

    public String toString() {
        return this.nome + "\t" + this.cognome + "\t" + this.noleggi;
    }

    public String toString(Map<Integer, Veicolo> codVeicolo) {
        return this.nome + "\t" + this.cognome + "\t" + this.noleggioPiuCostoso(codVeicolo) + "\t" + noleggi.size();
    }

    public double noleggioPiuCostoso(Map<Integer, Veicolo> codVeicolo) {
        double noleggioPiuCostoso = 0;
        for (Noleggio n : noleggi) {
            double tmp = codVeicolo.get(n.getCodiceVeicolo()).getCostoGiornaliero() * n.getNumeroGiorni();
            if (tmp > noleggioPiuCostoso) {
                noleggioPiuCostoso = tmp;
            }
        }
        return noleggioPiuCostoso;
    }

    public int getNumNoleggi(int codiceVeicolo) {
        int i = 0;
        for (Noleggio n : noleggi) {
            if (codiceVeicolo == n.getCodiceVeicolo()) {
                i++;
            }

        }
        return i;
    }
}
