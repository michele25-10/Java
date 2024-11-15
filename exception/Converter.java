package linguaggiProgrammazione.exception;

public class Converter {
    public Converter(String[] args) throws IllegalArgumentException, NumberFormatException {
        for (int i = 0; i < args.length; i++) {
            int x = Integer.parseInt(args[i]);
            if (x < -10 || x > 10) {
                throw new IllegalArgumentException("Sei fuori dall'intervallo [-10; 10]");
            }
            System.out.println(x);
        }
    }

}