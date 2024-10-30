package simulazione24;

public class Progetto {
    private int codice;
    private String titolo;
    private String nome, cognome;
    private String organizzatore;
    private int numeroPartner;
    private double importoTotale;

    public Progetto(int codice, String titolo, String nome, String cognome, String organizzatore, int numeroPartner,
            double importoTotale) {
        this.codice = codice;
        this.titolo = titolo;
        this.nome = nome;
        this.cognome = cognome;
        this.organizzatore = organizzatore;
        this.numeroPartner = numeroPartner;
        this.importoTotale = importoTotale;
    }

    public int getCodice() {
        return this.codice;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getOrganizzatore() {
        return this.organizzatore;
    }

    public int getNumeroPartner() {
        return this.numeroPartner;
    }

    public double getImportoTotaleMigliaia() {
        return this.importoTotale * 1000;
    }

    public String toString() {
        return this.titolo + "\t" + this.codice + "\t" + this.nome + " " + this.cognome;
    }
}
