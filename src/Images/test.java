package Images;
import processing.core.*;

public class test extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Images.test");
    }

    public void settings() {
        size(800, 800);
    }

    PImage img;

    public void setup() {
        img = loadImage("src/Images/Venus.jpg");
        img.loadPixels();

        // Ensure image is big enough
        if (img.width < 1 || img.height < 1) {
            println("Image too small!");
            exit();
        }

        // New image to store result
        PImage result = createImage(img.width, img.height, ARGB);
        result.loadPixels();

        // Loop over each row
        for (int y = 0; y < img.height; y++) {
            int maxValue = Integer.MIN_VALUE;
            int maxX = 0;

            // Find max pixel in the current row
            for (int x = 0; x < img.width; x++) {
                int index = y * img.width + x;
                if (img.pixels[index] > maxValue) {
                    maxValue = img.pixels[index];
                    maxX = x;
                }
            }

            // Set only the max pixel in that row
            for (int x = 0; x < img.width; x++) {
                int index = y * img.width + x;
                if (x == maxX) {
                    result.pixels[index] = img.pixels[index];  // Keep original
                } else {
                    result.pixels[index] = color(0);           // Set to black
                }
            }
        }

        result.updatePixels();
        image(result, 0, 0, 800, 800);
    }
}





















































//package Images;
//import processing.core.*;
//import java.util.Arrays;
//
//public class Venus extends PApplet {
//    public static void main(String[] args) {
//        PApplet.main("Images.Venus");
//    }
//
//    public void settings() {
//        size(800, 800);
//        smooth(0);
//    }
//
//    PImage img;
//
//    public void setup() {
//        img = loadImage("src/Images/beans.jpg");
//        img.loadPixels();
//
////        // Ensure image is large enough
////        if (img.width < 500 || img.height < 500) {
////            println("Image too small for 500x500 region!");
////            exit();
////        }
//
//        int max = Integer.MIN_VALUE;
//        int maxIndex = 0;
//
//        int[] pix = Arrays.copyOf(img.pixels, img.pixels.length);
//
//        // Search for the brightest pixel in top-left 500x500 region
//        for (int y = 0; y < 500; y++) {
//            for (int x = 0; x < 500; x++) {
//                int index = y * img.width + x;
//                if (pix[index] > max) {
//                    max = pix[index];
//                    maxIndex = index;
//                } else {
//                    pix[index] = color(0, 0, 0); // Black out non-max
//                }
//            }
//        }
//
//        // Restore max pixel
//        pix[maxIndex] = max;
//
//        // Create output image
//        PImage imax = createImage(img.width, img.height, ARGB);
//        imax.loadPixels();
//        for (int i = 0; i < pix.length; i++) {
//            imax.pixels[i] = pix[i];
//        }
//        imax.updatePixels();
//
//        image(imax, 0, 0);
//    }
//}





































//package Images;
//import processing.core.*;
//
//import java.util.Arrays;
//
//public class Venus extends PApplet {
//    public static void main(String[] args) {
//        PApplet.main("Images.Venus");
//    }
//
//    public void settings() {
//        size(800, 800);
//        smooth(0);
//    }
//
//    PImage img;
//
//    public void setup() {
//        img = loadImage("src/Images/beans.jpg");
//        img.loadPixels();
//        System.out.println(img.pixels.length);
//        int[] maximg = new int[500];
//        int max =  MIN_INT;
//        int[] pixPos = new int[2];
//        int[] pix = Arrays.copyOf(img.pixels, img.pixels.length);
//        for (int i = 0; i < 500; i++) {
//            for (int j = 0; j < 500; j++) {
//                    if (img.pixels[i+j] > max) {
//                        max = img.pixels[i+j];
//                        pixPos[0] = i;
//                        pixPos[1] = j;
//                    } else {
//                        pix[i+j] = 0;
//                    }
//            }
//            pix[pixPos[0]+pixPos[1]] = max;
////            println("Pixel " + i + ": " + img.pixels[i] + " | Hex: " + hex(img.pixels[i]) +
////                    " | R: " + red(img.pixels[i]) + ", G: " + green(img.pixels[i]) + ", B: " + blue(img.pixels[i]) + ", A: " + alpha(img.pixels[i]));
//        }
//
//        PImage imax = createImage(img.width, img.height, ARGB);
//        imax.loadPixels();
//        for (int i = 0; i < 500; i++) {
//            for (int j = 0; j < 500; j++) {
//                imax.pixels[i+j] = pix[i+j];
//            }
//        }
//        imax.updatePixels();
//        image(imax, 0, 0);
//
//    }
//}
