import java.util.Collections;

public class sortPractice {
    
    public static void main (String[] args) {

        int[] arr = new int[] {30, 129, 13, 193, 3, 1, 0, 1931, 200};
        int sortedValues = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = sortedValues;
            for (int j = sortedValues; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int placeholder = arr[sortedValues];
            arr[sortedValues] = arr[minIndex];
            arr[minIndex] = placeholder;
            sortedValues++;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}