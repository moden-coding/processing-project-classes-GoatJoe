import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.*;
import processing.opengl.PShapeOpenGL;

public class App extends PApplet {

    ArrayList<Bullet> bullets;
    private boolean space = true;
    private int ballHeath = 3;
    private PImage balll;
    private double highScore;
    private float speed = 90;
    private double begin;
    private PApplet canvas;
    // SoundFile music;
    private double timer;
    private int x = 66;
    private Ball ball;
    private int y = 530;
    private boolean gameOver;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        // add fetures such as a image and shape, this also creates arraylists
        bullets = new ArrayList<>();

        balll = loadImage("Screenshot 2026-01-14 200554.png");
        balll.resize(width, height);
        ball = new Ball(x, y, this, ballHeath);

        ball.updateColor();
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

    // Ai help me come up with (
    public void restartGame() {
        bullets.clear();
        Bullets();
        gameOver = false;
        ballHeath = 3;
        begin = millis();
        ball = new Ball(x, y, this, ballHeath);
        // )
    }

    public void death() {
        // float distanceFromBullet = canvas.dist(x, y, X2, Y2);
        for (int i = bullets.size() - 1; i >= 0; i--) {
            Bullet bullet = bullets.get(i);
            if (bullet.touches(ball)) {
                ballHeath--;
                bullets.remove(i);
                // AI helped with (
                ball.setHealth(ballHeath);
                // )

                println("health:", ballHeath, "gameOver:", gameOver);

                println("HP decreased! HP = " + ballHeath);
            }

        }
        // if (distanceFromBullet < / 2) {
        // ballHeath--;
        // System.out.println("hp decreased");
        // }
    }

    public void settings() {
        // screen size
        size(1000, 600);
    }

    public void draw() {

        if (frameCount % 100 == 0) {
            print("100 frames have passed");
            Bullets();
        }
        // add background/more images
        image(balll, 0, 0);
        // creates floor and ball
        fill(0, 0, 0);
        rect(0, 550, 1000, 50);

        ball.display();
        ball.updateColor();
        ball.update();

        // bullets.get(0).update();
        // bullets.get(1).update();
        // bullets.get(2).update();
        // bullets.get(3).update();
        // System.out.println(bullets.size());
        // if (bull = true) {

        // System.out.println("bullet move");
        for (Bullet b : bullets) {
            b.display();
            b.update();
        }

        // }
        timer = millis() - begin;
        timer = ((int) timer / 100) / 10.0;
        text("" + timer, width - 100, 50);
        textSize(19);
        if (timer == 1) {

        }
        text(ballHeath + " HP left", 100, 50);
        death();
        if (ballHeath <= 0) {
            gameOver = true;
        }
        if (gameOver == true) {
            bullets.clear();
            fill(255, 0, 0);
            textSize(89);
            background(0);
            text("GAME OVER", 300, 300);
            textSize(19);
            fill(250, 250, 250);
            text("use the button g insead of space for a intense challenge", 400, 150);

        }
        fill(0, 0, 255);
        text("click b to restart", 400, 580);
        if (space = true) {
            fill(255, 0, 255);
            text("click space to move", 400, 60);
        }
    }

    public void keyPressed() {
        // detects when key pressed and then moves the ball
        if (key == ' ') {
            ball.move();
            space = false;

            // y -= speed;
            // if (y < 440) {
            // y = 440;
            // }
            // bullets.get(0).update();
            // bullets.get(1).update();
            // bullets.get(2).update();
            // bullets.get(3).update();
        }
        if (key == 'b') {
            restartGame();

        }
        if (key == 'g') {
            ball.move();
            space = false;

            if (frameCount % 30 == 0) {
                print("30 frames have passed");
                Bullets();
            }
        }

    }

    public void keyReleased() {
        // knows when key released and stops movement
        if (key == ' ') {
            y = 530;

        }

    }

    // public void readHighScore() {
    // // high score creation
    // try (Scanner scanner = new Scanner(Paths.get("highscore.txt"))) {
    // // we read the file until all lines have been read
    // while (scanner.hasNextLine()) {
    // // we read one line
    // String row = scanner.nextLine();
    // // we print the line that we read
    // highScore = Double.valueOf(row);
    // }
    // } catch (Exception e) {
    // System.out.println("Error: " + e.getMessage());
    // }
    // }
    // did not have time to finish but might comeback and finish for fun

}
