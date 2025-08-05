package TheNatureOfCode.Chapter1.RandomWalk;

import processing.core.PApplet;

import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class RandomWalker {
    float x, y;
    PApplet sketch;
    Random generator = new Random();

    RandomWalker(PApplet sketch) {
        this.sketch = sketch;
        x = (float) sketch.width /2;
        y = (float) sketch.height /2;
    }

    void display() {
        sketch.stroke(0);
        sketch.point(x, y);
    }

    void step1() {
        int choice = (int)(sketch.random(4));
        if (choice == 0) {
            x++;
        } else if (choice == 1) {
            x--;
        } else if (choice == 2) {
            y++;
        } else {
            y--;
        }
    }

    void step2() {
        int stepx = (int)sketch.random(3) - 1;
        int stepy = (int)sketch.random(3) - 1;
        x += stepx;
        y += stepy;
    }

    void step3() {
        float stepx = sketch.random(-1, 1);
        float stepy = sketch.random(-1, 1);
        x += stepx;
        y += stepy;
    }

    void step4() {
        int stepx = (int) (2*generator.nextGaussian());
        int stepy = (int) (2*generator.nextGaussian());
        x += stepx;
        y += stepy;
    }

    void step5() {
        float choice = (sketch.random(1));
        if (choice <= 0.1) {
            float dx = sketch.mouseX - x;
            float dy = sketch.mouseY - y;
            float distance = (float)sqrt(dx*dx + dy*dy);
            if (distance != 0) {
                dx /= distance;
                dy /= distance;
            } else {
                dx = 0;
                dy = 0;
            }
            x+= dx;
            y+= dy;
        } else if (choice <= 0.4) {
            x++;
        }else if (choice <=0.6) {
            x--;
        } else if (choice <=0.8) {
            y++;
        } else {
            y--;
        }
    }
}
