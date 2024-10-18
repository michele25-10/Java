package linguaggiProgrammazione.simulazione1;

public class Prenotazione {
    private int codice, oraInizio;

    public Prenotazione(int codice, int oraInizio) {
        this.codice = codice;
        this.oraInizio = oraInizio;
    }

    public String toString() {
        String returnString = codice + " ," + oraInizio;
        return returnString;
    }

    public int getCodice() {
        return this.codice;
    }

    public int getOraInizio() {
        return this.oraInizio;
    }
}
