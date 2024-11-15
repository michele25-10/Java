package linguaggiProgrammazione.jcf2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Prova {
    public static void main(String[] args) {
        ArrayList<Call> callList = new ArrayList<Call>();
        try (FileReader f = new FileReader("data.txt");
                BufferedReader bufferedReader = new BufferedReader(f);) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                String[] stringSplit = line.split(";");
                Call call = new Call(stringSplit[0], stringSplit[1], Integer.parseInt(stringSplit[2]),
                        Integer.parseInt(stringSplit[3]));
                if (call.getDuration() > 550000) {
                    callList.add(call);
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File data.txt not found.");
        } catch (IOException e) {
            System.out.println("Errore di I/O: " + e.getMessage());
        }

        System.err.println(callList.toArray().length);
    }
}