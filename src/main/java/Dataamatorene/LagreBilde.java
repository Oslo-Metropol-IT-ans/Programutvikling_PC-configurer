package Dataamatorene;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LagreBilde {

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

    public static Image lasteBilde() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        Image selectedFile = new Image(fileChooser.showOpenDialog(null).getAbsolutePath());

        if (selectedFile != null) {
            return selectedFile;
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
