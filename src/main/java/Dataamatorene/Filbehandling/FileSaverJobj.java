package Dataamatorene.Filbehandling;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileSaverJobj implements FileSaver { // Lagrer filer til jobjFil
    public void save(ArrayList<? extends Serializable> liste, String path) throws IOException {
        try (OutputStream os = Files.newOutputStream(Paths.get(path));
             ObjectOutputStream out = new ObjectOutputStream(os))
        {
            out.writeObject(liste);
        }catch (IOException IOE){
            System.err.println("Lagring feilet");
            IOE.getStackTrace();
        }

    }
}
