import processing.core.PApplet;

public class Sketch extends PApplet {

    private Ball ball1;
    private Ball ball2;
    private Ball ball3;
    private Ball ball4;

    private Bubble bubble1;
    private Bubble bubble2;
    private Bubble bubble3;
    private Bubble bubble4;

    private Snowflake snowflake1;
    private Snowflake snowflake2;
    private Snowflake snowflake3;
    private Snowflake snowflake4;

    /**
     * This method can only be used to change the window size. It runs before the
     * window is created.
     */
    public void settings() {
        size(500, 500);
    }

    /**
     * Runs once at the beginning of the program, after the window is created. Use
     * this to initialize the sketch.
     */
    public void setup() {
        ball1 = new Ball(this, random(10, 50), random(450), random(50, 450), random(-10, 10), random(-10, 10));
        ball2 = new Ball(this, random(10, 50), random(450), random(50, 450), random(-10, 10), random(-10, 10));
        ball3 = new Ball(this, random(10, 50), random(450), random(50, 450), random(-10, 10), random(-10, 10));
        ball4 = new Ball(this, random(10, 50), random(450), random(50, 450), random(-10, 10), random(-10, 10));

        bubble1 = new Bubble(this, random(10, 50), random(50, 450), random(50, 450), random(-2, 2), -0.5f);
        bubble2 = new Bubble(this, random(10, 50), random(50, 450), random(50, 450), random(-2, 2), -0.5f);
        bubble3 = new Bubble(this, random(10, 50), random(50, 450), random(50, 450), random(-2, 2), -0.5f);
        bubble4 = new Bubble(this, random(10, 50), random(50, 450), random(50, 450), random(-2, 2), -0.5f);

        snowflake1 = new Snowflake(this, random(10, 50), random(50, 450), random(50, 450), random(-2, 2), -0.5f);
        snowflake2 = new Snowflake(this, random(10, 50), random(50, 450), random(50, 450), random(-2, 2), -0.5f);
        snowflake3 = new Snowflake(this, random(10, 50), random(50, 450), random(50, 450), random(-2, 2), -0.5f);
        snowflake4 = new Snowflake(this, random(10, 50), random(50, 450), random(50, 450), random(-2, 2), -0.5f);

        // Mr. Griswold helped me understand color
        ball1.setColors(color(random(0, 255), random(0, 255), random(0, 255)), 0);
        ball2.setColors(color(random(0, 255), random(0, 255), random(0, 255)), 0);
        ball3.setColors(color(random(0, 255), random(0, 255), random(0, 255)), 0);
        ball4.setColors(color(random(0, 255), random(0, 255), random(0, 255)), 0);
    }

    /**
     * This method runs over and over and over, approximately 60 times per second!
     * By moving objects a tiny bit each frame, you can get the appearance of
     * movement.
     */
    public void draw() {
        background(180, 180, 255);
        ball1.draw();
        ball1.move();
        ball2.draw();
        ball2.move();
        ball3.move();
        ball3.draw();
        ball4.move();
        ball4.draw();

        bubble1.draw();
        bubble1.move();
        bubble2.draw();
        bubble2.move();
        bubble3.draw();
        bubble3.move();
        bubble4.draw();
        bubble4.move();

        snowflake1.draw();
        snowflake1.move();
        snowflake1.wind();
        snowflake2.draw();
        snowflake2.move();
        snowflake2.wind();
        snowflake3.draw();
        snowflake3.move();
        snowflake3.wind();
        snowflake4.draw();
        snowflake4.move();
        snowflake4.wind();
      
    }

    /** All processing sketches have to use this main method. Don't touch this! */
    public static void main(String[] args) {
        PApplet.main("Sketch");
    }
}
