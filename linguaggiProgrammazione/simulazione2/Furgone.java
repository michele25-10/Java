//package linguaggiProgrammazione.simulazione2;

public class Furgone extends Veicolo {
    private boolean rimorchio;
    private int numeroPosti;
    private boolean vanoCarico;

    public Furgone(int codice, String targa, String modello, String marca, double costoGiornaliero, boolean rimorchio,
            int numeroPosti,
            boolean vanoCarico) {
        super(codice, targa, modello, marca, costoGiornaliero);
        this.rimorchio = rimorchio;
        this.numeroPosti = numeroPosti;
        this.vanoCarico = vanoCarico;
    }

    public String toString() {
        return "Furgone \t" + super.toString() + "\t-\t-\t-\t" + this.rimorchio + "\t" + this.numeroPosti + "\t"
                + this.vanoCarico;
    }
}
