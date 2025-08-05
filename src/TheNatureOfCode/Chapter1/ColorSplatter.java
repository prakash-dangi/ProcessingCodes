package TheNatureOfCode.Chapter1;
import processing.core.*;

import java.util.Random;

public class ColorSplatter  extends PApplet{
    public static void main(String[] args) {
        PApplet.main("TheNatureOfCode.Chapter1.ColorSplatter");
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(255);
    }

    Random generator = new Random();
    Splatters s = new Splatters(this);
    int x, y;
    public void draw() {
        s.splatter();
    }
}
