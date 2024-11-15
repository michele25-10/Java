package linguaggiProgrammazione.simulazione38;

public class Noleggio {
    private int codiceVeicolo;
    private int numeroGiorni;

    public Noleggio(int codiceVeicolo, int numeroGiorni) {
        this.codiceVeicolo = codiceVeicolo;
        this.numeroGiorni = numeroGiorni;
    }

    public String toString() {
        return this.codiceVeicolo + " " + this.numeroGiorni;
    }
}
