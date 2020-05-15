package Dataamatorene.Filbehandling;

import Dataamatorene.Tasks.ThreadSaveJobjTask;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.ArrayList;

public class ThreadSaverJobj { // lagrer under egen tråd

    // Initialiserer variabler

    private ArrayList<? extends Serializable> liste;
    private String path;
    private Pane pane;

    // Konstruktør

    public ThreadSaverJobj(ArrayList<? extends Serializable> liste, String path, Pane pane) {
        this.path = path;
        this.liste = liste;
        this.pane = pane;
    }

    // lagre metoden

    public void save() {
        ThreadSaveJobjTask threadSaveJobjTask = new ThreadSaveJobjTask(liste, path);
        threadSaveJobjTask.setOnSucceeded(this::threadSaveJobjSuccess);
        threadSaveJobjTask.setOnRunning(this::threadSaveJobjRunning);
        Thread th = new Thread(threadSaveJobjTask);
        th.setDaemon(true);
        th.start();
    }

    // Hvis lagring fungerte

    private void threadSaveJobjSuccess (WorkerStateEvent e) {
        pane.setDisable(false);
    }

    // Deaktiverer GUI under lagring

    private void threadSaveJobjRunning (WorkerStateEvent e) {
        pane.setDisable(true);
    }
}
