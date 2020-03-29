package Dataamatorene.Tasks;

import Dataamatorene.App;
import javafx.concurrent.Task;

public class ThreadOpenLagKomponent extends Task<Void> {
    @Override
    protected Void call() throws Exception {
        App.setRoot("lagkomponent");

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){

        }

        return null;
    }
}
