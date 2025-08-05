package TheNatureOfCode.Chapter1.RandomWalk;
import processing.core.*;

public class RandomWalk extends PApplet {
    public static void main(String[] args) {
        PApplet.main("TheNatureOfCode.Chapter1.RandomWalk.RandomWalk");
    }

    public void settings() {
        size(800, 800);
    }

    RandomWalker w;
    public void setup(){
        background(255);
        w = new RandomWalker(this);
        frameRate(640);
    }

    public void draw() {
        w.step5();
        w.display();
    }
}

