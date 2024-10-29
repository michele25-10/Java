public class Hockey extends Squadra {
    private double nMedioFalli;

    public Hockey(int codice, String nome, int nVinte, int nPerse, double nMedioGoal, double nMedioFalli) {
        super(codice, nome, nVinte, nPerse, nMedioGoal);
        this.nMedioFalli = nMedioFalli;
    }

    public String toString() {
        return super.toString() + "\t" + super.getNumeroMedioGoal() + "\t" + this.nMedioFalli + "\t-\tHockey";
    }

}
