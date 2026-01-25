import processing.core.*;

public class Ball {
    // list all verablies for the ball asthetics
    private int X;
    private int Y;
    private int Size;
    private PApplet canvas;
    private int BallSpeed;
    private int color;
    private int ballHeath;

    public Ball(int x, int y, PApplet c, int B) {
        // asthetec details of screen
        X = x;
        Y = y;
        Size = 40;
        canvas = c;
        BallSpeed = 5;
        ballHeath = B;

    }

    public void display() {
        // health changes
        canvas.fill(color);
        canvas.circle(X, Y, Size);
        

    }
//Ai helped ()
    public void setHealth(int set) {
        ballHeath = set;
        updateColor();
    }
    //)

    public void update() {
        // reverses and edits speed

        if (X + 2 + Size / 2 > canvas.width || X - Size / 2 < 0) {
            BallSpeed = -BallSpeed;

        }
    }

    public void updateColor() {
        if (ballHeath == 3) {
            color = canvas.color(0, 245, 0);
        } else if (ballHeath == 2) {
            color = canvas.color(206, 100, 0);
        } else if (ballHeath == 1) {
            color = canvas.color(255, 0, 0);
        }

    }

    public void move() {
        X += BallSpeed;
        if (X + 2 + Size / 2 > canvas.width || X - Size / 2 < 0) {
            BallSpeed = -BallSpeed;

        }
    }
    // public boolean touches(Bullet bullets){
    // bullets.getx();
    // bullets.gety();
    // bullets.getsize();

    // }
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getSize() {
        return Size;
    }
}
