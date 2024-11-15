package linguaggiProgrammazione.sconto;

public interface PoliticaSconto {
    abstract double calcolaSconto(int numeroArticoli, double prezzoArticoli);
}
