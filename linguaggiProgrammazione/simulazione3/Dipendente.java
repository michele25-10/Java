package linguaggiProgrammazione.simulazione3;

public class Dipendente {

    private int codice;
    private String nome;
    private double costoOrario;

    public Dipendente(int codice, String nome, double costoOrario) {
        this.codice = codice;
        this.nome = nome;
        this.costoOrario = costoOrario;
    }

    public int getCodice() {
        return this.codice;
    }

    public String getNome() {
        return this.nome;
    }

    public double getCostoOrario() {
        return this.costoOrario;
    }

}
