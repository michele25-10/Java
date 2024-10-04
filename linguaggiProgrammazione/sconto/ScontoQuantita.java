package linguaggiProgrammazione.sconto;

public class ScontoQuantita implements PoliticaSconto {
    private int minimo;
    private int percentuale;

    public ScontoQuantita(int minimo, int percentuale) {
        this.minimo = minimo;
        this.percentuale = percentuale;
    }

    public double calcolaSconto(int numeroArticoli, double prezzoArticoli) {
        if (numeroArticoli > this.minimo) {
            return prezzoArticoli - (prezzoArticoli / 100) * this.percentuale;
        }

        return prezzoArticoli;
    }
}
