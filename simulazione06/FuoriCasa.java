package linguaggiProgrammazione.simulazione06;

public class FuoriCasa extends Partita {
    private String nomeCitta;

    public FuoriCasa(String nomeCitta, String data, String ora, String risultato, int vinto) {
        super(data, ora, risultato, vinto);
        this.nomeCitta = nomeCitta;
    }

    public String toString() {
        return "-\t" + this.nomeCitta + "\t" + super.toString();
    }

    public String getNomeCitta() {
        return nomeCitta;
    }
}
