package Dataamatorene.Filbehandling;

import Dataamatorene.Bestilling.Bestilling;
import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Dialogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileOpenerTxt implements FileOpener{ // Åpner txtFiler

    public ArrayList<Bestilling> read(String path) throws IOException {
        ArrayList<Bestilling> list = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line;

            reader.skip(0);
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("Navn")) {
                    System.out.println(line);

                    Bestilling b = Converter.parseBestilling(line);
                    list.add(b);
                }
            }
        }
        return list;
    }
}
