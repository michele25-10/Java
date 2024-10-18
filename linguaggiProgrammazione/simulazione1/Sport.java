package linguaggiProgrammazione.simulazione1;

public class Sport {
    private int codice;
    private String nome_campo;
    private float lunghezza, larghezza, costo_orario;

    public Sport(int codice, String nome_campo, float lunghezza, float larghezza, float costo_orario) {
        this.codice = codice;
        this.nome_campo = nome_campo;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.costo_orario = costo_orario;
    }

    public int getCodice() {
        return this.codice;
    }

    public String getNomeCampo() {
        return this.nome_campo;
    }

    public float getLunghezza() {
        return this.lunghezza;
    }

    public float getLarghezza() {
        return this.larghezza;
    }

    public float getCostoOrario() {
        return this.costo_orario;
    }
}
