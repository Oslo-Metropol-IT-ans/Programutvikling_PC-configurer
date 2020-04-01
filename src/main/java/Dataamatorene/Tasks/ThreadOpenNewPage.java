package Dataamatorene.Tasks;

import Dataamatorene.App;
import javafx.concurrent.Task;

public class ThreadOpenNewPage extends Task<Void> {

    private String page;

    public ThreadOpenNewPage(String page) {
        this.page = page;
    }

    @Override
    protected Void call() throws Exception {
        App.setRoot(page);

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){

        }

        return null;
    }
}
