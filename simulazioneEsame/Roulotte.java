public class Roulotte extends Veicolo{
    private int peso; 
    private boolean veranda; 


    public Roulotte(int codice, String marcaVeicolo, int peso, float lunghezza, float larghezza, int postiLetto, boolean veranda, float costoGiornaliero){
        super(codice, marcaVeicolo, lunghezza, larghezza, postiLetto, costoGiornaliero); 
        this.peso = peso; 
        this.veranda = veranda; 
        }

    public String toString(){
        return "Roulotte\t" + super.toString() + "\t" + this.peso + "\t" + (this.veranda ? "si" : "no") + "\t-\t" + super.getCostoGiornaliero(); 
    }
}