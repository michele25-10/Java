package linguaggiProgrammazione.sconto;

public class CompraNArticoliPrendiUnoGratis implements PoliticaSconto {
    private int n;

    public CompraNArticoliPrendiUnoGratis(int n) {
        this.n = n;
    }

    public double calcolaSconto(int numeroArticoli, double prezzoArticoli) {
        if (numeroArticoli == this.n) {
            return 0;
        }
        return prezzoArticoli;
    }
}
