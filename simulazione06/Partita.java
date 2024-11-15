package linguaggiProgrammazione.simulazione06;

public class Partita {
    private String data;
    private String ora;
    private String risultato;
    private int vinto;

    public Partita(String data, String ora, String risultato, int vinto) {
        this.data = data;
        this.ora = ora;
        this.risultato = risultato;
        this.vinto = vinto;
    }

    public String toString() {
        return this.data + "\t" + this.ora + "\t" + this.risultato;
    }

    public String getNomeCitta() {
        return "";
    }
}
