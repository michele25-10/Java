package linguaggiProgrammazione.simulazione38;

public class Caravan extends Veicolo {
    private int potenza;

    public Caravan(int codice, String marca, float larghezza, float lunghezza, int potenza, int postiLetto,
            float costoGiornaliero) {
        super(codice, marca, lunghezza, larghezza, postiLetto, costoGiornaliero);
        this.potenza = potenza;
    }

    public String toString() {
        return "Caravan\t" + super.toString() + "\t-\t-\t" + this.potenza + "\t" + super.getCostoGiornaliero();
    }
}