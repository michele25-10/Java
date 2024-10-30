package simulazione24;

public class Ricerca extends Progetto {
    private String codiceArgomento;

    public Ricerca(int codice, String titolo, String nome, String cognome, String organizzazione,
            String codiceArgomento, int numeroPartner, double importoTotale) {
        super(codice, titolo, nome, cognome, organizzazione, numeroPartner, importoTotale);
        this.codiceArgomento = codiceArgomento;
    }

    public String toString() {
        return "Ricerca\t" + super.toString() + "\t" + this.codiceArgomento + "\t" + super.getNumeroPartner() + "\t"
                + super.getImportoTotaleMigliaia();
    }
}
