package Images.Convolutions;
import processing.core.*;

public class Convolution extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Images.Convolutions.Convolution");
    }
    int resX = 8192;
    int resY = 6144 ;
    int div = 8;
    int threshold = -10000000;
    public void settings() {
        size(resX/div, resY/div);
    }

    public void setup() {
        PImage img;
        img = loadImage("src/Images/Laser2.jpg");
//        img.filter(PConstants.GRAY);
        img.loadPixels();

//        int[] kernel = {-1, 0, -1, 0, 3, 0, -1, 0, -1};
//        {1, 0, 1, 0, 9, 0, 1, 0, 1}
//        {-1, 0, -1, 0, 3, 0, -1, 0, -1}
//        {2, -1, 2, -1, 507, -1, 2, -1, 2}
//        {2, -1, 2, -1, 509, -1, 2, -1, 2}, 508, 510
 //        {2, -1, 2, -1, 50, -1, 2, -1, 2}
//        int[] kernel = new int[]{-1, -1, -1, -1, 9, -1, -1, -1, -1};
//        float[] kernel = new float[]{1f/9, 1f/9, 1f/9, 1f/9, 1f/9, 1f/9, 1f/9, 1f/9, 1f/9};
        int[] kernel = {0, -1, 0, -1, 5, -1, 0, -1, 0};
        Kernel k = new Kernel(kernel, img.pixels, resX, resY);
//        img.pixels = k.mask();
//        image(img, 0, 0, (float) resX /div, (float) resY /div);
        img.pixels = k.rMask(threshold);
        img.updatePixels();
        image(img, 0, 0, (float) resX /div, (float) resY /div);
//        image(img, 0, 0, 768, 1024);

    }
}
