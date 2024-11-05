class Ball {

    /*
     * In Processing, the Sketch works a lot like the World in the turtles. You
     * can't
     * draw a ball without knowing which sketch to draw it on, so you always need to
     * specify the sketch for a Ball object.
     */

    /** The sketch that the ball is inside */
    private Sketch s;
    /** the radius of the ball */
    private float radius;
    /** the x position of the ball */
    private float x;
    /** the y position of the ball */
    private float y;
    /** The number of pixels the ball moves right per frame */
    private float xSpeed;
    /** The number of pixels the ball moves down per frame */
    private float ySpeed;
    /** The color of the inside of the ball */
    private int fillColor;
    /** The color of the outside of the ball */
    private int borderColor;

    /** Empty constructor to keep the defaults. Only sets up our link. */
    public Ball(Sketch sketch) {
        s = sketch;
        radius = 20;
        x = 100;
        y = 100;
        xSpeed = 2;
        ySpeed = -1;
        fillColor = s.color(255, 100, 100);
        borderColor = s.color(0, 0, 0);
    }

    /** Fully specified constructor to allow changes to size, position, speed */
    /** Does NOT allow changing color! Need to use setColors() for that. */
    public Ball(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
    }

    // Setters that you need go here - by default, only colors

    public void setColors(int fill, int border) {
        borderColor = border;
        fillColor = fill;
    }

    /**
     * Draws the ball on the given sketch
     */
    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor);
        s.circle(x, y, radius * 2);
    }

    /**
     * Moves the ball so that the next time it draws it will be in a different place. 
     * All of the gravity code is also here and all of it is commented.
     * Again, it would probably have been more readable if the gravity was its own
     * method but I didn't do that so oops.
     */
    public void move() {
        x = x - xSpeed;
        y = y + ySpeed;
        ySpeed = ySpeed + 0.1f; //adding to the ySpeed makes it so it loses downwards momentum every frame, giving the illusion of gravity
        if (x > s.width - radius) {
            x = s.width - radius;  // this is here to snap the ball into frame if it goes out of bounds
            xSpeed = -(xSpeed+0.5f); //removes speed from the ball after every collision
        } else if (x < radius){
            x = radius; // this is here to snap the ball into frame if it goes out of bounds
            xSpeed = -(xSpeed-0.5f); //removes speed from the ball after every collision
        }
        if (y > s.height - radius) {
            y = s.height - radius; // this is here to snap the ball into frame if it goes out of bounds
            ySpeed = -(ySpeed-1f); //removes speed from the ball after every collision
            xSpeed = xSpeed/1.05f; //removes speed from the ball after every collision, this one is specifically for the case when the ball is rolling on the ground

            /* 
            this is to get the balls to move again after they become still on the floor.
            again, probably should have been its own method.
             */
            if (s.keyPressed){
                ySpeed = s.random(-10,-5);
                xSpeed = s.random(-10,10);
            }
        } else if (y < radius){
            y = radius+1; // this is here to snap the ball into frame if it goes out of bounds
            ySpeed = -(ySpeed+1f); //removes speed from the ball after every collision
        }
    }

}

