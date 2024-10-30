package simulazione24;

import java.util.*;

public class Ricercatore {
    private String nome, cognome;
    private List<Impegno> impegni;

    public Ricercatore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.impegni = new LinkedList<Impegno>();
    }

    public void addImpegno(int codiceProgetto, double impegnoOrario) {
        this.impegni.add(new Impegno(codiceProgetto, impegnoOrario));
    }

    public String toString() {
        StringBuffer Listimpegni = new StringBuffer("[");
        double totaleOre = 0;
        for (Impegno i : this.impegni) {
            totaleOre += i.getImpegnoOrario();
            Listimpegni.append("(" + i.getCodiceProgetto() + ", " + i.getImpegnoOrario() + "),");
        }
        Listimpegni.append("]");
        return this.nome + "\t" + this.cognome + "\t" + totaleOre + "\t" + Listimpegni.toString();
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String ricercaImpegnoPiuAlto() {
        double maxHour = 0;
        int codiceProgetto = 0;
        for (Impegno i : this.impegni) {
            if (i.getImpegnoOrario() > maxHour) {
                maxHour = i.getImpegnoOrario();
                codiceProgetto = i.getCodiceProgetto();
            }
        }
        return maxHour + "\t" + Gestione.codProgetto.get(codiceProgetto).getTitolo();
    }
}