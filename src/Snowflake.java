import processing.core.PVector;

class Snowflake {

    /** The sketch that the snowflake is inside */
    private Sketch s;
    /** the radius of the snowflake */
    private float radius;
    /** the x position of the snowflake */
    private float x;
    /** the y position of the snowflake */
    private float y;
    /** The number of pixels the snowflake moves right per frame */
    private float xSpeed;
    /** The number of pixels the snowflake moves down per frame */
    private float ySpeed;



/** Empty constructor to keep the defaults. Only sets up our link. */
public Snowflake(Sketch sketch) {
    s = sketch;
    radius = 20;
    x = 100;
    y = 100;
    xSpeed = 2;
    ySpeed = 1;
}

/** Fully specified constructor to allow changes to size, position, speed */
public Snowflake(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
    this.s = sketch;
    this.radius = radius;
    this.x = x;
    this.y = y;
    this.xSpeed = xspeed;
    this.ySpeed = -yspeed; //set y speed to negative cus its falling
}

// methods

/** This is the wind method. I creates a vector to the mouse position and a vector
 * to the the center the snowflake. It subracts those vectors to get the vector from 
 * the mouse to the snowflake. It then uses the distance between the mouse and the 
 * snowflake to determine the strength of the wind, and 
 * used the normalized the vector to get the direction of the wind. 
 * It then multiplies the direction vector to the wind strength
 * and adds the x component of the vector to the x speed and 
 * the y component to the y speed.
 */
public void wind(){
    PVector mouseVector = new PVector(s.mouseX,s.mouseY);
    PVector myVector = new PVector(x,y);
    PVector windVector = mouseVector.sub(myVector);
    float size = Math.max(5,1/Sketch.dist(x, y, s.mouseX, s.mouseY));
    PVector speedVector = windVector.normalize().mult(-size/250);
    xSpeed += speedVector.x;
    ySpeed += speedVector.y;
}

/**
 * Draws the snowflake on the given sketch
 */
    public void draw() {
        s.line(x+radius,y,x-radius,y);
        s.line(x,y+radius,x,y-radius);
        s.line(x+radius*.707f,y+radius*.707f,x-radius*.707f,y-radius*.707f);
        s.line(x+radius*.707f,y-radius*.707f,x-radius*.707f,y+radius*.707f);
    }

    //copy and pasted from bubbles and it worked
    /** Moves the snowflake so that the next time it draws it will be in a different place */
    public void move() {
        x = x + xSpeed;
        y = y + ySpeed;
        if (x > s.width - radius || x < radius) {
            xSpeed = -xSpeed; //just copied and pasted it from the ball code to have it bounce off the sides
        } else if (y > s.height - radius) {
            y = radius;
        } else if (y < radius) {
            y = s.height - radius;
        }
    }

}


