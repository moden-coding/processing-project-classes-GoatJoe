import processing.core.*;

public class Ball {
    
    private int X;
    private int Y;
    private int Size;
    private PApplet canvas;
    private int BallSpeed;
    private int color;
    private int ballHeath;

    public Ball(int x, int y, PApplet c) {
        X = x;
        Y = y;
        Size = 24;
        canvas = c;
        BallSpeed = 5;
        ballHeath = 3;
        
    }


}
