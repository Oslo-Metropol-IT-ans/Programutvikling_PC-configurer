package Dataamatorene.Tasks;

import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
import javafx.concurrent.Task;

import java.io.Serializable;
import java.util.ArrayList;

public class ThreadSaveJobjTask extends Task<Void> {
    FileSaver saver;

    ArrayList<? extends Serializable> liste;
    String path;

    public ThreadSaveJobjTask(ArrayList<? extends Serializable> liste, String path) {
        this.liste = liste;
        this.path = path;
    }

    @Override
    protected Void call() throws Exception {
        saver = new FileSaverJobj();

        saver.save(liste, path);

        return null;
    }
}
