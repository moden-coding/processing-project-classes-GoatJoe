import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.*;


public class App extends PApplet {
    ArrayList<Ball> balls;
    private PImage balll;
    private boolean space;
    private double highScore;
    // SoundFile music;
                int x = 56; 
                int y = 10;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        //add fetures such as a image and shape
        balls = new ArrayList<>();
        balll = loadImage("Screenshot 2026-01-07 091025.png");
        Ball ball = new Ball(x, y, this);
         balls.add(ball);
        // music = new SoundFile(this, )
    }

    public void motion(){
        //movent of hero
     println("motion");
            if (space == true) {
                println("circle move");
                
            }
        }

    public void settings() {
        //screen size
        size(1000, 600);
    }

    public void draw() {
        //add background/more images
        background(23,0,43);
        image(balll,290,160);

    }

    public void keyPressed() {
        //detects when key pressed
        if (key == ' ') {
            space = true;
        }

    }

    public void keyReleased() {
        // knows when key realsed
        if (key == ' ') {
            space = false;
        }
    }
    public void readHighScore() {
        //high score creation
        try (Scanner scanner = new Scanner(Paths.get("highscore.txt"))) {
            // we read the file until all lines have been read
            while (scanner.hasNextLine()) {
                // we read one line
                String row = scanner.nextLine();
                // we print the line that we read
                highScore = Double.valueOf(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
