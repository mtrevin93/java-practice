public class PrimitiveOperations {
    public static void main(String[] args) {
        int intNum = 20;
        double floatNum = 3.5;
        System.out.println(intNum);
        System.out.println(floatNum);
        double product = intNum * floatNum;
        System.out.println(product);
        double castInt = intNum;
        System.out.println(castInt);
        int castDouble = (int) floatNum;
        System.out.println(castDouble);
        char myChar = 'A';
        System.out.println(myChar);
        int numChar = myChar;
        int lowercaseNumChar = numChar + 32;
        char lowercaseChar = (char)lowercaseNumChar;
        System.out.println(lowercaseChar);



    }
}