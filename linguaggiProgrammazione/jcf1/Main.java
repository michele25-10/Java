package linguaggiProgrammazione.jcf1;

public class Main {
    public static void main(String[] args) {
        Patologia asma = new Patologia("asma", 10);
        Patologia allergia = new Patologia("allergia", 2);

        Pazienti paziente = new Pazienti("Rossi");
        paziente.aggiungiPatologia(asma);
        paziente.aggiungiPatologia(allergia);

        System.out.println(paziente.toString());

        try {
            asma.aggrava();
        } catch (Exception e) {
            System.out.println(e);
        }

        while (allergia.getGrado() != 0) {
            try {
                allergia.attenua();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(paziente.toString());

    }
}
