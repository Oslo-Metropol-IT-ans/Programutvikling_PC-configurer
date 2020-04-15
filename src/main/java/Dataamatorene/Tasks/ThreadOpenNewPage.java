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

    @Override
    protected Parent call() throws Exception {

        updateMessage("Laster inn siden");

        Parent parent = App.loadFXML(page);

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }

        updateMessage("Åpningen av siden var velykket\nVenligst vent...");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }

        updateMessage("Velykket");


        return parent;
    }
}
