package linguaggiProgrammazione.simulazione20;

public class Iscritto {
    private int codice;
    private String nome, cognome;
    private String indirizzo;
    private String nomeAccount, password;

    public Iscritto(int codice, String nome, String cognome, String indirizzo, String nomeAccount, String password) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.nomeAccount = nomeAccount;
        this.password = password;
    }

    public String toString() {
        return this.codice + "\t" + this.nome + "\t" + this.cognome;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public String getNomeAccount() {
        return this.nomeAccount;
    }

    public String getPassword() {
        return this.password;
    }

    public int getCodice() {
        return this.codice;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getRagioneSociale() {
        return "-";
    }
}
