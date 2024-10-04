public class EsempioGioco {
    public static void main(String[] args) {
        GruppoAlieni ga = new GruppoAlieni(3);
        ga.aggiungiAlieno(new AlienoSerpente(
                100, "Sirbiss"), 0);
        ga.aggiungiAlieno(new AlienoOrco(
                100, "Shrek"), 1);
        ga.aggiungiAlieno(new AlienoUomoMarshmallow(
                100, "Mork"), 2);
        System.out.println("Danno: " + ga.calcolaDanno());
    }
}