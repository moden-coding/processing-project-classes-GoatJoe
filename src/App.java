import java.lang.reflect.Array;
import java.util.ArrayList;
import processing.core.*;

public class App extends PApplet {
    ArrayList<Ball> balls;
    private PImage ball;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        balls = new ArrayList<>();
        ball = loadImage("bball");

    }

    public void settings() {
        size(1000, 900);
    }

    public void draw() {
        background(ball);

    }
}
