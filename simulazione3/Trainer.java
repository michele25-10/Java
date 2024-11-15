package linguaggiProgrammazione.simulazione3;

public class Trainer extends Dipendente {
    private int oreSettimanali;
    private String specialita;

    public Trainer(int codice, String nome, int oreSettimanali, double costoOrario, String specialita) {
        super(codice, nome, costoOrario);
        this.oreSettimanali = oreSettimanali;
        this.specialita = specialita;
    }

    public String toString() {
        return super.getNome() + "\t" + super.getCodice() + "\t" + "trainer" + this.oreSettimanali + "\t"
                + this.specialita + "\t-\t-\t-\t" + super.getCostoOrario();
    }
}
