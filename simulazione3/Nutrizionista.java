package linguaggiProgrammazione.simulazione3;

public class Nutrizionista extends Dipendente {
    private int telefono;
    private boolean medico;
    private int appuntamentiSettimanali;

    public Nutrizionista(int codice, String nome, int telefono, boolean medico, int appuntamentiSettimanali,
            double costoOrario) {
        super(codice, nome, costoOrario);
        this.telefono = telefono;
        this.medico = medico;
        this.appuntamentiSettimanali = appuntamentiSettimanali;
    }

    public String toString() {
        return super.getNome() + "\t" + super.getCodice() + "\t" + "nutrizionista\t-\t-\t"
                + this.telefono + "\t" + this.medico + "\t" + this.appuntamentiSettimanali + "\t"
                + super.getCostoOrario();
    }
}
