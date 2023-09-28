package Day252;

import java.util.Arrays;

public class waveArray {

    public static void wa(int arr[], int n) {
        for (int i=0; i<n-1; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int n1 = 5;
        int arr2[] = {2,4,7,8,9,10};
        int n2 = 6;
        wa(arr1, n1);
        wa(arr2, n2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}