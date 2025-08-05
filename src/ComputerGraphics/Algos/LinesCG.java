package ComputerGraphics.Algos;
import processing.core.*;

public class LinesCG extends PApplet {

    public void line_dda(int x1, int y1, int x2, int y2) {
       int dx = x2 - x1;
       int dy = y2 - y1;
       int steps = 0;

       if (Math.abs(dx) > Math.abs(dy)) {
           steps = abs(dx);
       } else {
           steps = abs(dy);
       }

       if (steps == 0) {
           
       }
    }


    public void settings() {
        size(800, 800);
        smooth(0);
    }

    public void setup() {
        background(0);
    }
}
