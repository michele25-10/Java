public class Giocatore {
    private int codiceSquadra;
    private String cognome, nome;
    private int eta, numeroMaglia;
    private String ruolo;
    private boolean titolare;

    public Giocatore(int codiceSquadra, String cognome, String nome, int eta, int numeroMaglia, String ruolo,
            boolean titolare) {
        this.codiceSquadra = codiceSquadra;
        this.cognome = cognome;
        this.nome = nome;
        this.eta = eta;
        this.numeroMaglia = numeroMaglia;
        this.ruolo = ruolo;
        this.titolare = titolare;
    }

    public String toString() {
        return this.nome + "\t" + this.cognome + "\t" + this.eta + "\t" + this.numeroMaglia + "\t" + this.ruolo + "\t"
                + this.titolare + Gestione.codSquadra.get(this.codiceSquadra).getNome();
    }
}
