package Dataamatorene.Filbehandling;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public interface FileOpener {

    ArrayList<? extends Serializable> read(String path) throws IOException, ClassNotFoundException;

}
