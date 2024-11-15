package linguaggiProgrammazione.simulazione20;

public class Azienda extends Iscritto {
    private String ragioneSociale;

    public Azienda(int codice, String ragioneSociale, String indirizzo, String nome, String cognome, String nomeAccount,
            String password) {
        super(codice, nome, cognome, indirizzo, nomeAccount, password);
        this.ragioneSociale = ragioneSociale;
    }

    public String toString() {
        return super.getCodice() + "\t-\t-\t" + this.ragioneSociale + "\t" + super.getNome() + "\t" + this.getCognome()
                + "\t" + super.getIndirizzo() + "\t" + super.getNomeAccount() + "\t" + super.getPassword().length();
    }

    public String getRagioneSociale() {
        return this.ragioneSociale;
    }
}
