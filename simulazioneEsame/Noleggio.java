public class Noleggio {
    private int codiceVeicolo, numeroGiorni; 

    public Noleggio(int codiceVeicolo, int numeroGiorni){
        this.codiceVeicolo = codiceVeicolo; 
        this.numeroGiorni = numeroGiorni;
    }

    public String toString(){
        return this.codiceVeicolo + " " + this.numeroGiorni + ",";      
    }
}

