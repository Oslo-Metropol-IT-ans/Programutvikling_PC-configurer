package Dataamatorene.Tasks;

import Dataamatorene.App;
import Dataamatorene.Controllers.MenyAdminController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.util.Duration;

public class ThreadOpenNewPage extends Task<Parent> {

    private final String page;

    public ThreadOpenNewPage(String page) {
        this.page = page;
    }
    // Task for å laste fxmlFil til Parent
    @Override
    protected Parent call() throws Exception {

        updateMessage("Laster inn siden");

        // Bruker App sin loadFXML metode
        Parent parent = null;
        try {
            parent = App.loadFXML(page);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tråd sover 2 sek for å vise sensor

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }

        updateMessage("Åpningen av siden var vellykket\nVennligst vent...");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }

        updateMessage("Vellykket");


        return parent;
    }
}
