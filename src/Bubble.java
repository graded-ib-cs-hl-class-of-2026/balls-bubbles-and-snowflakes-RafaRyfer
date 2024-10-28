class Bubble {

    //MISSING MANY INSTANCE VARIABLES
     /** The sketch that the bubble is inside */
     private Sketch s;
     /** the radius of the bubble */
     private float radius;
     private float x;
     private float y;
     /** The number of pixels the bubble moves right per frame */
     private float xSpeed;
     /** The number of pixels the bubble moves down per frame */
     private float ySpeed;
     /** The color of the inside of the bubble */
     private int fillColor;
     /** The color of the outside of the bubble */
     private int borderColor;

    //MISSING CONSTRUCTORS

        /** Empty constructor to keep the defaults. Only sets up our link. */
        public Bubble(Sketch sketch) {
            s = sketch;
            radius = 20;
            x = 100;
            y = 100;
            xSpeed = 2;
            ySpeed = -1;
            fillColor = s.color(180, 180, 255, 0); //learned how to make it transparent with mr griswold
            borderColor = s.color(0, 0, 0);
        }
    
        /** Fully specified constructor to allow changes to size, position, speed */
        /** Does NOT allow changing color! Need to use setColors() for that. */
        public Bubble(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
            this.s = sketch;
            this.radius = radius;
            this.x = x;
            this.y = y;
            this.xSpeed = xspeed;
            this.ySpeed = yspeed;
        }

    // accessors for the radius, diameter, x, and y values 
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

    public void draw() {
        s.stroke(borderColor);
        s.fill(180, 180, 255, 0);
        s.circle(x, y, radius*2);
    }


    //im guessing this extra stuff at the bottom is so that it disappears at the top and reappears at the bottom
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