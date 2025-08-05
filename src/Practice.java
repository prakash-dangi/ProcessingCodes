import processing.core.*;

public class Practice extends PApplet{
    int x = 200;
    public static void main(String[] args){
        PApplet.main("Practice");
    }

    public void settings(){
        size(800, 800);
        smooth(8);
    }

    public void setup() {
       background(255);
       frameRate(500);
//       for (int i = 0; i<255; i++){
//            for (int j = 0; j<255; j++){
//                stroke(i);
//                point(i + 200, j + 200);
//            }
//        }
        for(int i = 0; i<255; i++){
            for (int j = 0; j < 255; j++){
                stroke(i, j, i*j);
                point(i + 200, j*sin(radians(i)) + 200);
//                point(j*sin(radians(i))+ 200, i + 200);
                point(400 - i, j*sin(radians(i)) + 200);
                point(i + 200, 600 - j*sin(radians(i)));
                point(400 - i, 600 - j*sin(radians(i)));
            }
        }
    }

//    int i = 0;
//    int j = 0;
    public void draw() {
//        stroke(i);
//        point(i + 200, j*log(i) + 200);
//        point(j*log(i) + 200, i + 200);
//        i++;
//        if (i > 255){
//            j++;
//            i = 0;
//        }
//
//        if (j > 255){
//            noLoop();
//        }
    }

}
