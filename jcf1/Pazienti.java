package linguaggiProgrammazione.jcf1;

import java.util.ArrayList;

public class Pazienti {
    private String cognome;
    private ArrayList<Patologia> patologie;

    public Pazienti(String cognome) {
        this.cognome = cognome;
        this.patologie = new ArrayList<Patologia>();
    }

    public String getCognome() {
        return this.cognome;
    }

    public void aggiungiPatologia(Patologia p) {
        if (!this.patologie.contains(p)) {
            this.patologie.add(p);
        }
    }

    public void rimuoviPatologia(Patologia p) {
        if (!this.patologie.contains(p)) {
            this.patologie.remove(p);
        }
    }

    public String toString() {
        StringBuilder print = new StringBuilder(this.cognome + "\n");
        this.patologie.forEach(item -> {
            print.append(item.toString() + "\n");
        });
        return print.toString();
    }

}
