package linguaggiProgrammazione.jcf1;

class MoltoGraveException extends RuntimeException {

    public MoltoGraveException(String message) {
        super(message);
    }
}

class GuaritaException extends RuntimeException {

    public GuaritaException(String message) {
        super(message);
    }
}

public class Patologia {
    private String nome;
    private int grado;

    public Patologia(String nome, int grado) {
        this.nome = nome;
        this.grado = grado;
    }

    public String getNome() {
        return this.nome;
    }

    public int getGrado() {
        return this.grado;
    }

    public int aggrava() throws MoltoGraveException {
        if (this.grado == 10) {
            throw new MoltoGraveException("gravita 10");
        } else {
        }
        this.grado++;
        return this.grado;
    }

    public int attenua() throws GuaritaException {
        if (this.grado == 0) {
            throw new GuaritaException("gravità 0");
        }
        this.grado--;
        return this.grado;
    }

    public boolean equals(Patologia other) {
        if (other.nome.equals(this.nome)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.nome.toString() + " " + Integer.toString(this.grado);
    }
}
