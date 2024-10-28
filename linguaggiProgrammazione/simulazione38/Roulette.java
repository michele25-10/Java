package linguaggiProgrammazione.simulazione38;

public class Roulette extends Veicolo {
    private int peso;
    private boolean veranda;

    public Roulette(int codice, String marca, int peso, float lunghezza, float larghezza, int postiLetto,
            boolean veranda, float costoGiornaliero) {
        super(codice, marca, lunghezza, larghezza, postiLetto, costoGiornaliero);
        this.peso = peso;
        this.veranda = veranda;
    }

    public String toString() {
        return "Roulette\t" + super.toString() + "\t" + this.peso + "\t" + (this.veranda ? "si" : "no") + "\t-\t"
                + super.getCostoGiornaliero();
    }
}