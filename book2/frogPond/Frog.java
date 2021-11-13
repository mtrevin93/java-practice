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
    }
    
    public Frog(String name, double tongueSpeed, int age) {
        this.name = name;
        this.tongueSpeed = tongueSpeed;
        this.age = age;
    }

    public Frog(String name, double tongueSpeed, double ageInYears) {
        this.name = name;
        this.tongueSpeed = tongueSpeed;
        this.age = (int)ageInYears;
    }
}


// Methods
// You must use method overloading at least once. Do not create any other methods than those specified. Any extra methods will result in point deductions. All methods must have the proper visibility to be used where it is specified they are used.

// grow - takes in a whole number parameter representing the number of months.
// Then it ages the Frog by the given number of months and increases tongueSpeed by 1 for every month the Frog grows until it becomes 12 months old.
// If the Frog is 30 months old or more, then decrease tongueSpeed by 1 for every month that it ages beyond 30 months.
// You must not decrease tongueSpeed to less than 5.
// Remember to update isFroglet accordingly
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