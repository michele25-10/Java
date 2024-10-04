package linguaggiProgrammazione.clinica;

public class Dottore extends Persona {
    private String specializzazione;
    private double parcella;

    public Dottore(String nome, String specializzazione, double parcella) {
        super(nome);
        this.specializzazione = specializzazione;
        this.parcella = parcella;
    }

    public String getSpecializzazione() {
        return this.specializzazione;
    }

    public double getParcella() {
        return this.parcella;
    }

    public boolean equals(Dottore altroDottore) {
        if (!super.equals(altroDottore)) {
            return false;
        }
        if (altroDottore.parcella != this.parcella) {
            return false;
        }
        if (altroDottore.specializzazione != this.specializzazione) {
            return false;
        }

        return true;
    }
}
