public class Squadra {
    private int codice;
    private String nome;
    private int nVinte, nPerse;
    private double nMedioGoal;

    public Squadra(int codice, String nome, int nVinte, int nPerse, double nMedioGoal) {
        this.codice = codice;
        this.nome = nome;
        this.nVinte = nVinte;
        this.nPerse = nPerse;
        this.nMedioGoal = nMedioGoal;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumeroVittorie() {
        return this.nVinte;
    }

    public int getNumeroSconfitte() {
        return this.nPerse;
    }

    public double getNumeroMedioGoal() {
        return this.nMedioGoal;
    }

    public String toString() {
        return this.nome + "\t" + this.codice + "\t" + this.nVinte + "\t" + this.nPerse;
    }
}
