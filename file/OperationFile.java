package linguaggiProgrammazione.file;

import java.io.*;

public class OperationFile {
    private String filename;

    public OperationFile(String filename) {
        this.filename = filename;
    }

    public void fileWriteLine(String line) {
        try {
            FileWriter fw = new FileWriter(this.filename, true);
            PrintWriter outFile = new PrintWriter(fw);
            outFile.println(line);
            outFile.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void printAllContentFile() {
        try (FileReader fr = new FileReader(this.filename);
                BufferedReader inFile = new BufferedReader(fr)) {

            String line = inFile.readLine();
            while (line != null) {
                System.out.println(line);
                line = inFile.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + this.filename + " not found.");
        } catch (IOException e) {
            System.out.println("Errore di I/O: " + e.getMessage());
        }
    }
}
