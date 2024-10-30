package simulazione24;

public class Impegno {
    private int codiceProgetto;
    private double impegnoOrario;

    public Impegno(int codiceProgetto, double impegnoOrario) {
        this.codiceProgetto = codiceProgetto;
        this.impegnoOrario = impegnoOrario;
    }

    public double getImpegnoOrario() {
        return this.impegnoOrario;
    }

    public int getCodiceProgetto() {
        return this.codiceProgetto;
    }
}
