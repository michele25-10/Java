package linguaggiProgrammazione.file;

import java.util.*;

public class File {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Errore, devi inserire il nome del file in cui scrivere in input");
            return;
        }
        System.out.println(args[0]);
        OperationFile opFile = new OperationFile(args[0]);

        Scanner tastiera = new Scanner(System.in);
        String input = tastiera.next();
        while (!input.equals("FINE")) {
            input = tastiera.next();
            opFile.fileWriteLine(input);
        }
        tastiera.close();
        opFile.printAllContentFile();
    }
}
