//package linguaggiProgrammazione.simulazione2;

public class Auto extends Veicolo {
    private double dimensioneBagagliaio;
    private int cilindrata;
    private String categoria;

    public Auto(int codice, String targa, String modello, String marca, double costoGiornaliero,
            double dimensioneBagagliaio, int cilindrata,
            String categoria) {
        super(codice, targa, modello, marca, costoGiornaliero);
        this.dimensioneBagagliaio = dimensioneBagagliaio;
        this.cilindrata = cilindrata;
        this.categoria = categoria;
    }

    public String toString() {
        return "Auto \t" + super.toString() + "\t" + this.dimensioneBagagliaio + "\t" + this.cilindrata + "\t"
                + this.categoria + "\t-\t-\t-";
    }
}
