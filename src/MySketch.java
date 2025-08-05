import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class MySketch extends PApplet {

    ArrayList<PVector> lastPoints;
    int t = 0;
    int steps = 10; // Total number of circles to draw

    public static void main(String[] args) {
        PApplet.main("MySketch");
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(0);
        strokeWeight(2);
        noFill();
        frameRate(1); // Optional slow-down to visualize
        translate(width / 2, height / 2);

        // Start from a random initial position
        float initialX = random(-300, 300);
        float initialY = random(-300, 300);
        lastPoints = drawCircle((int) random(0, 51), initialX, initialY);

        // Draw remaining steps
        for (int i = 1; i < steps; i++) {
            if (t == 1) {
                stroke(255, 0, 0);  // Red
                t = 0;
            } else {
                stroke(255);       // White
                t = 1;
            }

            PVector p = select(lastPoints);
            float r = random(0, 51);
            lastPoints = drawCircle((int) r, p.x, p.y);
        }

        noLoop(); // Stops draw() from running repeatedly
    }

    public void draw() {
        // Empty because everything is handled in setup()
    }

    public ArrayList<PVector> drawCircle(int r, float cx, float cy) {
        ArrayList<PVector> points = new ArrayList<>();
        beginShape();
        for (int i = 0; i <= 360; i++) {
            float angle = radians(i);
            float x = cx + r * cos(angle);
            float y = cy + r * sin(angle);
            vertex(x, y);
            points.add(new PVector(x, y));
        }
        endShape();
        return points;
    }

    public PVector select(ArrayList<PVector> p) {
        return p.get((int) random(p.size()));
    }
}
