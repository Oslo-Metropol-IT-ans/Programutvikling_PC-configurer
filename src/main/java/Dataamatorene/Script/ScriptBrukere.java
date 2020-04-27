package Dataamatorene.Script;

import Dataamatorene.Brukere.Bruker;
import Dataamatorene.Brukere.BrukerRegister;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ScriptBrukere {
    public static void main(String[] args) {
        Bruker b1 = new Bruker("Admin", "Admin", null, null, null, true);
        Bruker b2 = new Bruker("Nicolai", "a", "Nicolai", "48106487",
                "s341833@oslomet.no",true);
        Bruker b3 = new Bruker("Erik", "Erik123", "Erik", "93664190",
                "s341867@oslomet.no", true);
        Bruker b4 = new Bruker("Emilie", "Emilie123", "Emilie", "97833268",
                "s331394", true);
        Bruker b5 = new Bruker("Bruker", "Bruker123", null, null, null,
                false);
        Bruker b6 = new Bruker("Nicolai20", "Nicolai20", null, null, null,
                false);

        Bruker[] brukers = {b1,b2,b3,b4,b5, b6};

        BrukerRegister.setBrukere(new ArrayList<>(Arrays.asList(brukers)));
        FileSaver saver = new FileSaverJobj();

        try {
            saver.save(BrukerRegister.getBrukere(), "src/main/java/Dataamatorene/Files/Login.jobj");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
