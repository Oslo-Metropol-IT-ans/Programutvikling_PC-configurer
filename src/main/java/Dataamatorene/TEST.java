package Dataamatorene;

import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.time.LocalDate;

public class TEST {
    public static void main(String[] args) {
        FileSaver saver = new FileSaverJobj();
        try {
            saver.save(BestillingsRegister.getBestillinger(), "src/main/java/Dataamatorene/Files/Bestillinger.jobj");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
