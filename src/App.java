import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.*;
import processing.opengl.PShapeOpenGL;

public class App extends PApplet {
    ArrayList<Ball> balls;
    ArrayList<Bullet> bullets;
    private int ballHeath;
    private PImage balll;
    private boolean space;
    private double highScore;
    private float speed = 90;
    private double begin;
    private PApplet canvas;
    // SoundFile music;
    private double timer;
    private int x = 66;
    private Ball ball;
    private int y = 530;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        // add fetures such as a image and shape, this also creates arraylists
        bullets = new ArrayList<>();
        balls = new ArrayList<>();
        balll = loadImage("Screenshot 2026-01-14 200554.png");
        balll.resize(width, height);
        Ball ball = new Ball(x, y, this, ballHeath);
        balls.add(ball);
        Bullets();
        // music = new SoundFile(this, )
    }

    public void Bullets() {
        // creates bullets that appear in random spots
        int x = (int) random(800) + 125;
        int X = (int) random(800) + 125;
        int xx = (int) random(800) + 125;
        int XX = (int) random(800) + 125;
        int y = 40;
        int size = 10;
        int sIze = 20;
        Bullet I = new Bullet(x, y, size, sIze, this);
        Bullet II = new Bullet(X, y, size, sIze, this);
        Bullet III = new Bullet(XX, y, size, sIze, this);
        Bullet IV = new Bullet(xx, y, size, sIze, this);

        bullets.add(I);
        bullets.add(II);
        bullets.add(III);
        bullets.add(IV);

    }

    public void death(){
        //  float distanceFromBullet = canvas.dist(x, y, X2, Y2);
       for(Bullet bullet: bullets){
        if (bullet.touches(ball)) {
            ballHeath--;
            println("HP decreased! HP = " + ballHeath);
        }

    }
        // if (distanceFromBullet <  / 2) {
        //     ballHeath--;
        //     System.out.println("hp decreased");
        // }
    }
    
    public void settings() {
        // screen size
        size(1000, 600);
    }

    public void draw() {
        death();
        if (frameCount % 100 == 0) {
            print("100 frames have passed");
            Bullets();
        }
        // add background/more images
        image(balll, 0, 0);
        // creates floor and ball
        fill(0, 0, 0);
        rect(0, 550, 1000, 50);
        fill(0, 255, 0);
        for (Ball b : balls) {
            b.display();
        }
        // bullets.get(0).update();
        // bullets.get(1).update();
        // bullets.get(2).update();
        // bullets.get(3).update();
        // System.out.println(bullets.size());
        // if (bull = true) {
        for (Bullet b : bullets) {
            // System.out.println("bullet move");
            b.update();
            b.display();

        }
        // }
        timer = millis() - begin;
        timer = ((int) timer / 100) / 10.0;
        text("" + timer, width - 100, 50);
        textSize(19);
        if (timer == 1) {

        }

    }

    public void keyPressed() {
        // detects when key pressed and then moves the ball
        if (key == ' ') {
            balls.get(0).move();
            // y -= speed;
            // if (y < 440) {
            // y = 440;
            // }
            // bullets.get(0).update();
            // bullets.get(1).update();
            // bullets.get(2).update();
            // bullets.get(3).update();
        }

    }

    public void keyReleased() {
        // knows when key released and stops movement
        if (key == ' ') {
            space = false;
            y = 530;

        }
    }

    public void readHighScore() {
        // high score creation
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
