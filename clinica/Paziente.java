package linguaggiProgrammazione.clinica;

public class Paziente extends Persona {
    private String identificativo;

    public Paziente(String nome, String identificativo) {
        super(nome);
        this.identificativo = identificativo;
    }

    public String getIdentificativo() {
        return this.identificativo;
    }

    public boolean equals(Paziente altroPaziente) {
        if (!super.equals(altroPaziente)) {
            return false;
        }
        if (altroPaziente.identificativo != this.identificativo) {
            return false;
        }

        return true;
    }
}
