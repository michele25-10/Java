//package linguaggiProgrammazione.simulazione38;

public class Veicolo {
    private int codice;
    private String marca;
    private float lunghezza;
    private float larghezza;
    private int postiLetto;
    private float costoGiornaliero;

    public Veicolo(int codice, String marca, float lunghezza, float larghezza, int postiLetto, float costoGiornaliero) {
        this.codice = codice;
        this.marca = marca;
        this.lunghezza = lunghezza;
        this.postiLetto = postiLetto;
        this.costoGiornaliero = costoGiornaliero;
    }

    public int getCodice() {
        return this.codice;
    }

    public String getMarca() {
        return this.marca;
    }

    public float getLunghezza() {
        return this.lunghezza;
    }

    public int getPostiLetto() {
        return this.postiLetto;
    }

    public float getCostoGiornaliero() {
        return this.costoGiornaliero;
    }

    public float getLarghezza() {
        return this.larghezza;
    }

    public String toString() {
        return this.codice + "\t" + this.marca + "\t" + this.larghezza + "\t" + this.lunghezza + "\t" + this.postiLetto;
    }

}
