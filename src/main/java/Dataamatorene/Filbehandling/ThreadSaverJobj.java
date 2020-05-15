package Dataamatorene.Filbehandling;

import Dataamatorene.Tasks.ThreadSaveJobj;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.ArrayList;

public class ThreadSaverJobj {

    private ArrayList<? extends Serializable> liste;
    private String path;
    private Pane pane;

    public ThreadSaverJobj(ArrayList<? extends Serializable> liste, String path, Pane pane) {
        this.path = path;
        this.liste = liste;
        this.pane = pane;
    }

    public void save() {
        ThreadSaveJobj threadSaveJobj = new ThreadSaveJobj(liste, path);
        threadSaveJobj.setOnSucceeded(this::threadSaveJobjSuccess);
        threadSaveJobj.setOnRunning(this::threadSaveJobjRunning);
        Thread th = new Thread(threadSaveJobj);
        th.setDaemon(true);
        th.start();
    }

    private void threadSaveJobjSuccess (WorkerStateEvent e) {
        pane.setDisable(false);
    }

    private void threadSaveJobjRunning (WorkerStateEvent e) {
        pane.setDisable(true);
    }
}
