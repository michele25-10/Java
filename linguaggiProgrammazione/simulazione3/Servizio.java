package linguaggiProgrammazione.simulazione3;

public class Servizio {
    private int codiceDipendente;
    private double numeroOre;

    public Servizio(int codiceDipendente, double numeroOre) {
        this.codiceDipendente = codiceDipendente;
        this.numeroOre = numeroOre;
    }

    public double getPrezzoServizio() {
        return Gestionale.codDip.get(this.codiceDipendente).getCostoOrario() * this.numeroOre;
    }
}
