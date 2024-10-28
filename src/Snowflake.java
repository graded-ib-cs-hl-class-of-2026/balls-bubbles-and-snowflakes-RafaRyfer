class Snowflake {

    /** The sketch that the snowflake is inside */
    private Sketch s;
    /** the radius of the snowflake */
    private float radius;
    private float x;
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
/** Does NOT allow changing color! Need to use setColors() for that. */
public Snowflake(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
    this.s = sketch;
    this.radius = radius;
    this.x = x;
    this.y = y;
    this.xSpeed = xspeed;
    this.ySpeed = -yspeed; //set y speed to negative cus its falling
}

// Accessors (getters) go here

public float getRadius() {
    return radius;
}

public float getDiameter() {
    return radius * 2;
}

public float getX() {
    return x;
}

public float getY() {
    return y;
}

// Setters that you need go here - by default, only colors

/**
 * Draws the ball on the given sketch
 */
    public void draw() {
        s.line(x+radius,y,x-radius,y);
        s.line(x,y+radius,x,y-radius);
        s.line(x+radius*.707f,y+radius*.707f,x-radius*.707f,y-radius*.707f);
        s.line(x+radius*.707f,y-radius*.707f,x-radius*.707f,y+radius*.707f);
    }

    //copy and pasted from bubbles and it worked
    /** */
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


