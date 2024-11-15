package linguaggiProgrammazione.simulazione06;

public class Casa extends Partita {
    private String nomePalazzetto;

    public Casa(String nomePalazzetto, String data, String ora, String risultato, int vinto) {
        super(data, ora, risultato, vinto);
        this.nomePalazzetto = nomePalazzetto;
    }

    public String toString() {
        return this.nomePalazzetto + "\t-\t" + super.toString();
    }
}
