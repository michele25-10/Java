//package linguaggiProgrammazione.simulazione1;

public class Squash extends Sport {
    final static String nomeSport = "Squash";
    private float altezza;
    private int piano;

    public Squash(int codice, String nome_campo, float lunghezza, float larghezza, float altezza,
            int piano, float costo_orario) {
        super(codice, nome_campo, lunghezza, larghezza, costo_orario);
        this.altezza = altezza;
        this.piano = piano;
    }

    public String toString() {
        StringBuffer returnString = new StringBuffer();
        returnString.append(nomeSport).append(", ").append(this.getNomeCampo()).append(", ").append(this.getCodice())
                .append(", ").append(this.getLarghezza()).append(", ");
        returnString.append(this.getLunghezza()).append(", -, -, ").append(this.altezza).append(", ")
                .append(this.piano).append(", ").append(this.getCostoOrario()).append("\n");
        return returnString.toString();
    }
}
