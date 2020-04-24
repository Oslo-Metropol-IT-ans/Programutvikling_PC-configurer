package Dataamatorene;

import Dataamatorene.Bestilling.BestillingsRegister;
import Dataamatorene.Comparators.DatakomponentVarekodeComparator;
import Dataamatorene.Datakomponenter.*;
import Dataamatorene.Filbehandling.FileOpener;
import Dataamatorene.Filbehandling.FileOpenerJobj;
import Dataamatorene.Filbehandling.FileSaver;
import Dataamatorene.Filbehandling.FileSaverJobj;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TEST {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Harddisk h = new Harddisk("Hei", 10, 10001, null,1024);
        h.setBilde(new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/i9.jpg")));
        Harddisk h2 = new Harddisk("På", 100, 10002, null, 1024);
        h2.setBilde(new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/nia.jpg")));
        Harddisk h3 = new Harddisk("Deg", 1000, 10003, null, 1024);

        ArrayList<Harddisk> liste = new ArrayList<>();
        liste.add(h);
        liste.add(h2);
        liste.add(h3);

        for (Harddisk H:liste) {
            if(H.getBilde() != null) {
                System.out.println(H.getVarekode() + " har bilde");
            } else System.out.println(H.getVarekode() + " har ikke bilde");
        }

        FileSaver saver = new FileSaverJobj();
        saver.save(liste, "src/main/java/Dataamatorene/Pictures/niabia.jobj");

        FileOpener opener = new FileOpenerJobj();
        ArrayList<Harddisk> liste2 = (ArrayList<Harddisk>) opener.
                read("src/main/java/Dataamatorene/Pictures/niabia.jobj");

        for (Harddisk H:liste2) {
            if(H.getBilde() != null) {
                System.out.println(H.getVarekode() + " har bilde");
            } else System.out.println(H.getVarekode() + " har ikke bilde");
        }


        ArrayList<Harddisk> liste3 = new ArrayList<>();
        for (Harddisk H2:liste2) {
            //Image bilde = new Image(new FileInputStream("src/main/java/Dataamatorene/Pictures/nia.jpg"));
            Harddisk test = new Harddisk(H2.getNavn(), H2.getPris(), Integer.parseInt(H2.getVarekode()),
                    H2.getBilde(), Integer.parseInt(H2.getLagring()));
            liste3.add(test);
        }

        for (Harddisk H3:liste3) {
            if(H3.getBilde() != null) {
                System.out.println(H3.getVarekode() + " har bilde");
            } else System.out.println(H3.getVarekode() + " har ikke bilde");
        }

        saver.save(liste3, "src/main/java/Dataamatorene/Pictures/niabia.jobj");

        liste3 = (ArrayList<Harddisk>) opener.
                read("src/main/java/Dataamatorene/Pictures/niabia.jobj");

        for (Harddisk H:liste3) {
            if(H.getBilde() != null) {
                System.out.println(H.getVarekode() + " har bilde");
            } else System.out.println(H.getVarekode() + " har ikke bilde");
        }



    }

    /*
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        bilde = SwingFXUtils.toFXImage(ImageIO.read(s), null);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        ImageIO.write(SwingFXUtils.fromFXImage(bilde, null), "jpg", s);
    }

     */

}
