//package linguaggiProgrammazione.simulazione2;

public class Veicolo {
    private int codice;
    private String targa, modello, marca;
    private double costoGiornaliero;

    public Veicolo(int codice, String targa, String modello, String marca, double costoGiornaliero) {
        this.codice = codice;
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.costoGiornaliero = costoGiornaliero;
    }

    public String toString() {
        return this.targa + "\t" + this.codice + "\t" + this.modello + "\t" + this.marca + "\t" + this.costoGiornaliero;
    }

    public int getCodice() {
        return this.codice;
    }

    public double getCostoGiornaliero() {
        return this.costoGiornaliero;
    }
}
