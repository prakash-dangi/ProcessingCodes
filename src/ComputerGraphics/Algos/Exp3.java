package ComputerGraphics.Algos;
import processing.core.PApplet;

public class Exp3 extends PApplet {

    public static void main(String[] args) {
        PApplet.main("ComputerGraphics.Algos.Exp3");
    }

    public void settings() {
        size(800, 800);
        smooth(0);
    }

    public void setup(){
        background(0);
        stroke(255);
        strokeWeight(5);
        noFill();

        drawDot(50, 50);
        drawLine(70, 56, 89 , 20, 20, 70, 70);
        drawRectangle(10, 10, 50, 50);
        drawCircle(100, 100, 40);
    }

    public void drawDot(int x, int y) {
        point(x, y);
    }

    public void drawLine(int r, int g, int b, int x1, int y1, int x2, int y2) {
        stroke(r, g, b);
        line(x1, y1, x2, y2);
        stroke(255);
    }

    public void drawRectangle(int x, int y, int width, int height) {
        rect(x, y, width, height);
    }

    public void drawCircle(int x, int y, int radius) {
        ellipse(x, y, radius, radius);
    }
}
