package Dataamatorene.Filbehandling;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public interface FileSaver {
    void save(ArrayList<? extends Serializable> liste, String path) throws IOException;

    static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }


}
