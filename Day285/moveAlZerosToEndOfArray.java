package Day285;

import java.util.Arrays;

public class moveAlZerosToEndOfArray {
    static void pushZerosToEnd(int[] arr, int n) {
        // code here
        int zero = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[zero];
                arr[zero++] = arr[i];
                arr[i] = temp;
                
            }
        }
       
    }
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 4;
        int arr1[] = {3,5, 0, 0, 4};
        int arr2[] = {0, 0, 0, 4};
            
        pushZerosToEnd(arr1, n1);
        pushZerosToEnd(arr2, n2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}