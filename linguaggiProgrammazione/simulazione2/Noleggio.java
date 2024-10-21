//package linguaggiProgrammazione.simulazione2;

public class Noleggio {
    private int codiceVeicolo;
    private int numeroGiorni;

    public Noleggio(int codiceVeicolo, int numeroGiorni) {
        this.codiceVeicolo = codiceVeicolo;
        this.numeroGiorni = numeroGiorni;
    }

    public int getCodiceVeicolo() {
        return this.codiceVeicolo;
    }

    public int getNumeroGiorni() {
        return this.numeroGiorni;
    }

    public String toString() {
        return this.codiceVeicolo + "\t" + this.numeroGiorni;
    }
}
