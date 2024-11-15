package linguaggiProgrammazione.simulazione20;

public class Individuo extends Iscritto {
    public Individuo(int codice, String nome, String cognome, String indirizzo, String nomeAccount, String password) {
        super(codice, nome, cognome, indirizzo, nomeAccount, password);
    }

    public String toString() {
        return super.toString() + "\t-\t-\t" + super.getIndirizzo() + "\t" + super.getNomeAccount() + "\t"
                + super.getPassword().length();
    }
}
