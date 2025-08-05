package Images;
import processing.core.*;

public class Venus extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Images.Venus");
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        PImage img = loadImage("src/Images/Venus.jpg");
        img.loadPixels();

        for (int i = 0; i < img.pixels.length; i++) {
            if (red(img.pixels[i]) > 10 || blue(img.pixels[i]) > 100){
                img.pixels[i] = color(0);
            }
            img.pixels[i] = color(0, green(img.pixels[i]), 0);
        }

        img.updatePixels();
        image(img, 0, 0, 800, 800);
    }
}
