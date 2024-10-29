public class Veicolo {
    private int codice;
    private String marcaVeicolo;
    private float lunghezza, larghezza;
    private int postiLetto;
    private float costoGiornaliero;

    public Veicolo(int codice, String marcaVeicolo, float lunghezza, float larghezza, int postiLetto,
            float costoGiornaliero) {
        this.codice = codice;
        this.marcaVeicolo = marcaVeicolo;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.postiLetto = postiLetto;
        this.costoGiornaliero = costoGiornaliero;
    }

    public int getCodice() {
        return this.codice;
    }

    public String getMarcaVeicolo() {
        return this.marcaVeicolo;
    }

    public float getLunghezza() {
        return this.lunghezza;
    }

    public float getLarghezza() {
        return this.larghezza;
    }

    public int getPostiLetto() {
        return this.postiLetto;
    }

    public float getCostoGiornaliero() {
        return this.costoGiornaliero;
    }

    public String toString(){
        return this.codice + "\t" + this.marcaVeicolo + "\t" + this.larghezza + "\t" + this.lunghezza + "\t" + this.postiLetto; 
    }
}
