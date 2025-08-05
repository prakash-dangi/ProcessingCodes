package TheNatureOfCode.Chapter1;

import processing.core.PApplet;
import java.util.Random;

public class Splatters {
    float x, y;
    PApplet sketch;
    int[] colors;
    Random generator;

    public Splatters(PApplet sketch) {
        this.sketch = sketch;
        this.generator = new Random();
        colors = new int[]{
                sketch.color(255, 0, 0),      // red
                sketch.color(0, 255, 0),      // green
                sketch.color(0, 0, 255),      // blue
                sketch.color(255, 255, 0),    // yellow
                sketch.color(255, 165, 0),    // orange
                sketch.color(128, 0, 128),    // purple
                sketch.color(255, 192, 203),  // pink
                sketch.color(0, 255, 255),    // cyan
                sketch.color(255, 0, 255),    // magenta
                sketch.color(0, 128, 128),    // teal
                sketch.color(75, 0, 130),     // indigo
                sketch.color(165, 42, 42),    // brown
                sketch.color(128, 128, 128),  // gray
                sketch.color(0, 0, 0),        // black
                sketch.color(255, 255, 255)   // white
        };
    }

    public void splatter() {
        float meanx = sketch.width / 2f;
        float meany = sketch.height / 2f;
        float std = 70;

        x = meanx + std * (float) generator.nextGaussian();
        y = meany + std * (float) generator.nextGaussian();

        int index = (int) (7 + 10 * generator.nextGaussian());
        if (index >= 0 && index < colors.length) {
            sketch.stroke(colors[index]);
            sketch.fill(colors[index]);
        } else {
            sketch.noStroke();
            sketch.noFill();
        }

        sketch.ellipse(x, y, 5, 5);
    }
}
