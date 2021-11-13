import java.time.temporal.IsoFields;

public class Frog {
    //instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private final String species = "Rare Pepe";


    //static constants/variables
    public static final double defaultTongueSpeed = 5;
    public static final int defaultAge = 5;

    public Frog(String name) {
        this(name, defaultTongueSpeed, defaultAge);
        this.isFroglet = true;
    }
    
    public Frog(String name, double tongueSpeed, int age) {
        this.name = name;
        this.tongueSpeed = tongueSpeed;
        this.age = age;
        if (1 < this.age && this.age < 7) {
            this.isFroglet = true;
        }
    }

    public Frog(String name, double tongueSpeed, double ageInYears) {
        this.name = name;
        this.tongueSpeed = tongueSpeed;
        this.age = (int)ageInYears*12;
        if (1 < this.age && this.age < 7) {
            this.isFroglet = true;
        }
    }

    private void grow(int months) {
        int monthsUntil12 = 12 - this.age;
        if (monthsUntil12 > 0) {
            if (months < monthsUntil12) {
                tongueSpeed += months;
            }
            else tongueSpeed += monthsUntil12;
        }
        if (this.age + months > 30) {
            int monthsAfter30 = this.age+months - 30;
            this.tongueSpeed -= monthsAfter30;
        }
        this.age += months;
        if (this.tongueSpeed < 5) {
            this.tongueSpeed = 5;
        }
        if (1 < this.age && this.age < 7) {
            this.isFroglet = true;
        }
    }



}



// grow - takes in no parameters and ages the Frog by one month and updates tongueSpeed accordingly as for the other grow method
// eat – takes in a parameter of a Fly to attempt to catch and eat.
// Check if Fly is dead, and if it is dead then terminate the method.
// The Fly is caught if tongueSpeed is greater than the speed of the Fly.
// If the Fly is caught and the mass is at least 0.5 times the age of the Frog, the Frog ages by one month using the method grow. If the Fly is caught, the mass of the Fly must be set to 0.
// If the Fly is NOT caught, the mass of the Fly must be increased by 1 while updating the speed of the Fly using only one Fly method.
// toString - returns a String describing the Frog as follows:
// (Note: replace the values in brackets [] with the actual value. Do not include the double quotes “” or the square brackets [] in the output. Specify all decimal values to 2 decimal points.)
// If frog is a froglet, returns “My name is [name] and I’m a rare froglet! I’m [age] months old and my tongue has a speed of [tongueSpeed].”
// Otherwise, returns “My name is [name] and I’m a rare frog. I’m [age] months old and my tongue has a speed of [tongueSpeed].”
// Setter and getter for species which must change the value for all instances of the class. Points will be deducted if you include an unnecessary or inappropriate setter/getter.