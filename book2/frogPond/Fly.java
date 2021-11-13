public class Fly {
    //instance variables
    private double mass;
    private double speed;

    //static constants/variables
    public static final double defaultMass = 5;
    public static final double defaultSpeed = 10;

    public Fly (double mass) {
        this(mass, defaultSpeed);
    };

    public Fly (double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String toString() {
        if (this.mass == 0) {
            return "I'm dead, but I used to be a fly with a speed of " + this.speed;
        }
        else return "I'm a speedy fly with " + speed + "speed and " + mass + " mass";
    }

    private void grow(int growthAmount) {
        if (this.mass > 20) {
            double growthUntil20 = 20 - this.mass;
            if (growthAmount - growthUntil20 > 0) {
                this.speed += growthUntil20;
                this.speed -= (growthAmount - growthUntil20) * 0.5;
            }
            else {
                this.speed -= growthAmount * 0.5;
            }
            this.mass += growthAmount;
        }

    }

    private boolean isDead() {
        boolean isDead = false;
        if (this.mass == 0) {
            isDead = true;
        }
        return isDead;
    }
}