package hw13.task13_3_1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProxy implements DisplayObject {
    private final String path;
    private ImageFile imageFile;
    private BufferedImage image;

    public ImageProxy(String path) {
        this.path = path;
        this.imageFile = null;
    }

    public void display() {
        if (imageFile == null) {
            image = load(path);
            imageFile = new ImageFile(image);
        }
        imageFile.display();
    }

    private BufferedImage load(String path) {
        System.out.println("Loading image " + path + "...");
        BufferedImage image = null;
        File file = new File(path);
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}