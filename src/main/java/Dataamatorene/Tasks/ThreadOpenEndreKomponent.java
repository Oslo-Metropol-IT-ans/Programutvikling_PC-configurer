package Dataamatorene.Tasks;

import Dataamatorene.App;
import javafx.concurrent.Task;

public class ThreadOpenEndreKomponent extends Task<Void> {
    @Override
    protected Void call() throws Exception {
        App.setRoot("endrekomponent");

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){

        }

        return null;
    }
}
