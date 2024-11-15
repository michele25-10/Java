//package linguaggiProgrammazione.simulazione1;

public class Tennis extends Sport {
    final static String nomeSport = "tennis";
    private float temperatura_media;
    private String terreno;

    public Tennis(int codice, String nome_campo, float lunghezza, float larghezza, float temperatura_media,
            String terreno, float costo_orario) {
        super(codice, nome_campo, lunghezza, larghezza, costo_orario);
        this.temperatura_media = temperatura_media;
        this.terreno = terreno;
    }

    public String toString() {
        StringBuffer returnString = new StringBuffer();
        returnString.append(nomeSport).append(", ").append(this.getNomeCampo()).append(", ").append(this.getCodice())
                .append(", ").append(this.getLarghezza()).append(", ");
        returnString.append(this.getLunghezza()).append(", ").append(this.temperatura_media).append(", ")
                .append(this.terreno).append(", ");
        returnString.append("-, -, ").append(this.getCostoOrario()).append("\n");
        return returnString.toString();
    }
}
