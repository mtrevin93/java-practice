public class Frog {
    //instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    //static constants/variables
    public static final double defaultTongueSpeed = 5;
    public static final int defaultAge = 5;

    public Frog(String name) {
        this(name, (double)defaultAge/12, defaultTongueSpeed);
    }
    
    public Frog(String name, int age, double tongueSpeed) {
        this(name, (double)age/12, tongueSpeed);
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this.name = name;
        this.tongueSpeed = tongueSpeed;
        this.age = (int)(ageInYears*12);
        if (1 < this.age && this.age < 7) {
            this.isFroglet = true;
        }
    }

    public void grow(int months) {
        int monthsUntil12 = 12 - this.age;
        if (monthsUntil12 > 0) {
            if (months <= monthsUntil12) {
                this.tongueSpeed += months;
            }
            else this.tongueSpeed += monthsUntil12;
        }
        if (this.age > 30) {
            this.tongueSpeed -= months;
        }
        else if (age + months > 30) {
            int monthsUntil30 = 30 - age;
            if (months-monthsUntil30 > 0) {
                tongueSpeed -= (months-monthsUntil30);
            }
        }
        this.age += months;
        if (this.tongueSpeed < 5) {
            this.tongueSpeed = 5;
        }
        if (1 < this.age && this.age < 7) {
            this.isFroglet = true;
        }
    }

    public void grow() {
        int monthsUntil12 = 12 - this.age;
        if (monthsUntil12 > 0) {
            this.tongueSpeed += 1;
        }
        if (this.age >= 30) {
            this.tongueSpeed -= 1;
        }
        this.age += 1;
        if (this.tongueSpeed < 5) {
            this.tongueSpeed = 5;
        }
        if (1 < this.age && this.age < 7) {
            this.isFroglet = true;
        }
    }

    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        }
        if (this.tongueSpeed > fly.getSpeed()) {
            if (fly.getMass() >= 0.5 * this.age) {
                this.grow();
            }
            fly.setMass(0);
            }
        else {
            fly.grow(1);
        }
    }

    public String toString() {
        if (isFroglet) {
            return "My name is " + name + " and I'm a rare froglet! I'm " + age + 
            " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
        }
        else {
            return "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed" +
            " of " + String.format("%.2f", tongueSpeed) + ".";
        }
    }

    public static void setSpecies(String species) {
        Frog.species = species;
    }

    public static String getSpecies() {
        return Frog.species;
    }

}