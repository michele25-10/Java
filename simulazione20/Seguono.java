package linguaggiProgrammazione.simulazione20;

import java.util.*;

public class Seguono {
    private int codiceIscritto;
    private List<Integer> iscritti;

    public Seguono(int codiceIscritto) {
        this.codiceIscritto = codiceIscritto;
        this.iscritti = new LinkedList<Integer>();
    }

    public void addIscritto(int cod) {
        iscritti.add(cod);
    }

    public String toString() {
        String ragioneSociale = Gestionale.codIscritto.get(this.codiceIscritto).getRagioneSociale();
        return this.codiceIscritto + "\t" + Gestionale.codIscritto.get(this.codiceIscritto).getNome() + "\t"
                + Gestionale.codIscritto.get(this.codiceIscritto).getCognome() + "\t" + ragioneSociale + "\t"
                + this.iscritti.size();
    }

}
