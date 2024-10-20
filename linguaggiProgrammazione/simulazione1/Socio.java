//package linguaggiProgrammazione.simulazione1;

import java.util.ArrayList;

public class Socio {
    private int codice;
    private String nomeCognome;
    private int eta;
    private int categoria;
    private ArrayList<Prenotazione> prenotazioni;

    public Socio(int codice, String nomeCognome, int eta, int categoria) {
        this.codice = codice;
        this.nomeCognome = nomeCognome;
        this.eta = eta;
        this.categoria = categoria;
        this.prenotazioni = new ArrayList<Prenotazione>();
    }

    public void addPrenotazione(int codiceCampo, int oraInizio) {
        Prenotazione p = new Prenotazione(codiceCampo, oraInizio);
        this.prenotazioni.add(p);
    }

    public String toString() {
        StringBuffer returnString = new StringBuffer();
        returnString.append(this.codice).append(", ").append(this.nomeCognome).append(", ").append(this.eta)
                .append(", ").append(this.categoria).append(", ");
        prenotazioni.forEach(item -> {
            returnString.append(item.getCodice()).append(" ");
        });
        returnString.append("\n");
        return returnString.toString();
    }

    public float costoPrenotazioneCampo(int codice, float tariffa) {
        final float[] total = { 0 };
        prenotazioni.forEach(item -> {
            if (codice == item.getCodice()) {
                total[0] += tariffa * item.getOraInizio();
            }
        });
        return total[0];
    }
}
