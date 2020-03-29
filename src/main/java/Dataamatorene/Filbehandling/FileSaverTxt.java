package Dataamatorene.Filbehandling;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class FileSaverTxt implements FileSaver { // lagrer filer av type txt
    public void save(ArrayList<? extends Serializable> liste, String path) throws IOException {
        /*
        String objects = "";
        for(Bruker p:liste){
            //objects += Converter.toFil(p) + "\n";
        }
        Files.write(Paths.get(path), objects.getBytes());

         */
    }

}
