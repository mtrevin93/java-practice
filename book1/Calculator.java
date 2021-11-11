import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation: ");
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        // input.close();

        switch(command.toLowerCase()) {

            default: {
                System.out.println("Invalid input entered. Terminating...");
                break;
            }

            case "add": {
                System.out.println("Enter two integers: ");
                // Scanner addInput = new Scanner(System.in);
                if(input.hasNextInt()){
                boolean isInt = false;
                if (input.hasNextFloat()) {
                    float number = input.nextFloat();
                    if (number == (int) number) {
                        isInt = true;
                        boolean isInt2 = false;
                        if (input.hasNextFloat()) {
                            float number2 = input.nextFloat();
                            if (number2 == (int) number2) {
                                isInt2 = true;
                                if (isInt == false || isInt2 == false) {
                                    System.out.println("Invalid input entered. Terminating...");
                                    break;
                                }
                                int result = (int) number + (int) number2;
                                System.out.println(result);
                                // input.close();
                                break;
                                }}
                            }
                        }
                    }
                    else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    // input.close();
                }
                case "subtract": {
                    System.out.println("Enter two integers: ");
                    if(input.hasNextInt()){

                        // Scanner subtractInput = new Scanner(System.in);
                        boolean isInt = false;
                        if (input.hasNextFloat()) {
                            float number = input.nextFloat();
                            if (number == (int) number) {
                                isInt = true;}
                                boolean isInt2 = false;
                                if (input.hasNextFloat()) {
                                    float number2 = input.nextFloat();
                                    if (number2 == (int) number2) {
                                        isInt2 = true;}
                                        if (isInt == false || isInt2 == false) {
                                            System.out.println("Invalid input entered. Terminating...");
                                            break;
                                        }
                                        int result = (int) number - (int) number2;
                                        System.out.println(result);
                                        input.close();
                                        break;
                                    }
                                }
                                
                                // input.close();
                            }
                            else {
                                System.out.println("Invalid input entered. Terminating...");
                                break;
                            }
                            }
                            
                            
                        case "multiply": {
                        System.out.println("Enter two doubles: ");
                        if(input.hasNextFloat()){
                        // Scanner multiplyInput = new Scanner(System.in);
                        boolean isInt = false;
                        if (input.hasNextFloat()) {
                            float number = input.nextFloat();
                            if (number == (int) number) {
                                isInt = true;}
                                boolean isInt2 = false;
                                if (input.hasNextFloat()) {
                                    float number2 = input.nextFloat();
                                    if (number2 == (int) number2) {
                                        isInt2 = true;}
                                        // if (isInt == true || isInt2 == true) {
                                        //     System.out.println("Invalid input entered. Terminating...");
                                        //     break;
                                        // }
                                        float result = number * number2;
                                        System.out.printf("%.2f",result);
                                        // input.close();
                                        break;
                                        }}
                                    }
                                    else {
                                        System.out.println("Invalid input entered. Terminating...");
                                        break;
                                    }
                                }
                            
                            // input.close();
                        
    
                        case "divide": {
                            System.out.println("Enter two doubles: ");
                            if(input.hasNextFloat()){
                            // Scanner divideInput = new Scanner(System.in);
                            boolean isInt = false;
                            if (input.hasNextFloat()) {
                                float number = input.nextFloat();
                                if (number == (int) number) {
                                    isInt = true;}
                                    boolean isInt2 = false;
                                    if (input.hasNextFloat()) {
                                        float number2 = input.nextFloat();
                                        if(number2 == 0){
                                            System.out.println("Invalid input entered. Terminating...");
                                            // input.close();
                                            break;}
                                        if (number2 == (int) number2) {
                                            isInt2 = true;}
                                            // if (isInt == true || isInt2 == true) {
                                            //     System.out.println("Invalid input entered. Terminating...");
                                            //     break;
                                            // }
                                            float result = number / number2;
                                            System.out.printf("%.2f", result);
                                            // input.close();
                                            break;
                                            }}
                                        }
                                        else {
                                            System.out.println("Invalid input entered. Terminating...");
                                            break;
                                        }
                                    }
                                
                                // input.close();
                            

                case "alphabetize": {
                    System.out.println("Enter two words: ");
                    // Scanner wordInput = new Scanner(System.in);
                    String wordOne = input.next();
                    String wordTwo = input.next();
                    String testOne = wordOne.toLowerCase();
                    String testTwo = wordTwo.toLowerCase();
                    // input.close();
                    int result = testOne.compareTo(testTwo);
                    if(result == 0) {
                        System.out.println("Answer: Chicken or Egg.");
                        break;
                    }
                    else if(result < 0) {
                        System.out.println("Answer: " + wordOne + " comes before " + wordTwo + " alphabetically.");      
                        break;  
                    }
                    else if(result > 0) {
                        System.out.println("Answer: " + wordTwo + " comes before " + wordOne + " alphabetically.");        
                        break;
                    }
                }

    
        }
        input.close();
    }
}