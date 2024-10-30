package simulazione24;

public class Innovazione extends Progetto {
    public Innovazione(int codice, String titolo, String nome, String cognome, String organizzazione,
            String codiceArgomento, int numeroPartner, double importoTotale) {
        super(codice, titolo, nome, cognome, organizzazione, numeroPartner, importoTotale);
    }

    public String toString() {
        return "Innovazione\t" + super.toString() + "\t-\t" + super.getNumeroPartner() + "\t"
                + super.getImportoTotaleMigliaia();
    }
}
