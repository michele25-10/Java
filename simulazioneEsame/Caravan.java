public class Caravan extends Veicolo{
    private int potenza; 


    public Caravan(int codice, String marcaVeicolo, float larghezza,float lunghezza, int potenza, int postiLetto, float costoGiornaliero){
        super(codice, marcaVeicolo, lunghezza, larghezza, postiLetto, costoGiornaliero);
        this.potenza = potenza; 
        }

    public String toString(){
        return "Caravan\t" + super.toString() + "\t-\t-\t" + this.potenza + "\t" + super.getCostoGiornaliero(); 
    }
}




