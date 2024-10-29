public class Pallamano extends Squadra {
    public Pallamano(int codice, String nome, int nVinte, int nPerse, double nMedioGoal) {
        super(codice, nome, nVinte, nPerse, nMedioGoal);
    }

    public String toString() {
        return super.toString() + "\t-\t-\t" + super.getNumeroMedioGoal() + "\tPallamano";
    }
}
