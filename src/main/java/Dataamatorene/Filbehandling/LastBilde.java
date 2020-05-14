package Dataamatorene.Filbehandling;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LastBilde {

    public static File lasteBildeFil() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            String path = selectedFile.getPath();
            return selectedFile;
        }

        return null;
    }

    public static Image lasteBilde() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            return new Image(new FileInputStream(selectedFile.getAbsolutePath()));
        }

        return null;
    }

    public static void saveToFile(File image) {
        String bilde = "test.jpg";
        File outputFile = new File(String.format("src/main/java/Dataamatorene/Pictures/%s", bilde));
        try {
            BufferedImage bImage = ImageIO.read(image);
            ImageIO.write(bImage, "jpg", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
