package Dataamatorene.Filbehandling;

import Dataamatorene.Tasks.ThreadSaveJobj;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.layout.Pane;
import org.w3c.dom.Node;

import java.io.Serializable;
import java.util.ArrayList;

public class ThreadSaverJobj {

    private static ThreadSaveJobj threadSaveJobj;

    private ArrayList<? extends Serializable> liste;
    private String path;
    private Pane node;

    public ThreadSaverJobj(ArrayList<? extends Serializable> liste, String path, Pane node) {
        this.path = path;
        this.liste = liste;
        this.node = node;
    }

    public void save() {
        threadSaveJobj = new ThreadSaveJobj(liste, path);
        threadSaveJobj.setOnSucceeded(this::threadSaveJobjSuccess);
        threadSaveJobj.setOnRunning(this::threadSaveJobjRunning);
        Thread th = new Thread(threadSaveJobj);
        th.setDaemon(true);
        th.start();
    }

    private void threadSaveJobjSuccess (WorkerStateEvent e) {
        node.setDisable(false);
    }

    private void threadSaveJobjRunning (WorkerStateEvent e) {
        node.setDisable(true);
    }
}
