package linguaggiProgrammazione.clinica;

public class Clinica {
    public static void main(String[] args) {
        Dottore[] dottori = new Dottore[2];
        Paziente[] pazienti = new Paziente[2];
        Fattura[] fatture = new Fattura[2];

        dottori[0] = new Dottore("Maria", "Cardiochirurgo", 15);
        dottori[1] = new Dottore("Marco", "Pediatra", 25);

        pazienti[0] = new Paziente("Sofia", "15a6s1d");
        pazienti[1] = new Paziente("Clara", "asdahvda,");

        fatture[0] = new Fattura(pazienti[0], dottori[0]);
        fatture[1] = new Fattura(pazienti[1], dottori[1]);

        System.out.println(fatture[0].importo() + fatture[1].importo());
    }
}
