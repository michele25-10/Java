package linguaggiProgrammazione.clinica;

public class Fattura {
    private Paziente paziente;
    private Dottore dottore;

    public Fattura(Paziente paziente, Dottore dottore) {
        this.paziente = paziente;
        this.dottore = dottore;
    }

    public Paziente getPaziente() {
        return this.paziente;
    }

    public Dottore getDottore() {
        return this.dottore;
    }

    public boolean equals(Fattura altraFattura) {
        if (!this.dottore.equals(altraFattura.dottore)) {
            return false;
        }
        if (!this.paziente.equals(altraFattura.paziente)) {
            return false;
        }

        return true;
    }

    public double importo() {
        return this.dottore.getParcella();
    }
}
