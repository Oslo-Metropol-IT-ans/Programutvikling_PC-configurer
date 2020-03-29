package Dataamatorene.Filbehandling;

import Dataamatorene.Brukere.Bruker;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileOpenerTxt implements FileOpener{ // Åpner txtFiler

    public ArrayList<Bruker> read(String path) throws IOException {
        ArrayList<Bruker> list = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line;

        }
        return list;
    }
}
