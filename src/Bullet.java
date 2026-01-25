import processing.core.PApplet;

public class Bullet {
    // veriables
    private int X;
    private int Y;
    private int Size;
    private int size;
    private int Speed;
    private PApplet canvas;



    public Bullet(int x, int y, int I, int II, PApplet c) {
        //asthetec details of the bullet such as 
        X = x;
        Y = y;
        Size = I;
        size = II;
        Speed = 5;
        canvas = c;

    }
    public void display(){
         canvas.fill(0, 0, 0);
        canvas.rect(X, Y, Size, size);
       
    }

    public boolean touches(Ball ball){
        // System.out.println("balls location " + ball.getX() + ", " + ball.getY());
        // System.out.println("bullets location: " + X + ", " + Y);

        int xI = ball.getX();
        int yI = ball.getY();
        int sizeI = ball.getSize() / 2;
     //chat GPT help (
    boolean hit =
        X < xI + sizeI && X + Size > xI - sizeI && Y < yI + sizeI && Y + size > yI - sizeI;

    return hit;
    //)
    }
    //  public int getx(){
    //     return X;
    // }
    // public int gety(){
    //     return Y;
    // }
    // public int getsize(){
    //     return Size;
    // }
    public void update(){
            Y = Y + 3;
        if (X >= 1000){

        }
    } 
    


}
