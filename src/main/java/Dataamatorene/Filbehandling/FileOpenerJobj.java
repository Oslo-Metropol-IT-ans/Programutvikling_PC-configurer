package Dataamatorene.Filbehandling;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileOpenerJobj implements FileOpener { //Åpner jobj filer
    public ArrayList<? extends Serializable> read(String pathInn) throws IOException, ClassNotFoundException {

        try (InputStream is = Files.newInputStream(Paths.get(pathInn));
             ObjectInputStream in = new ObjectInputStream(is))
        {
            ArrayList<? extends Serializable> brukerArrayList =  (ArrayList<? extends Serializable>) in.readObject();
            return brukerArrayList;
        }
    }
}
