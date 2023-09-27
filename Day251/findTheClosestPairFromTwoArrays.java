package Day251;

import java.util.ArrayList;
import java.util.List;

public class findTheClosestPairFromTwoArrays {

    public static List<Integer> printClosest(int arr[], int brr[], int x) {
        List<Integer> answer = new ArrayList<>();
        
         int min = Integer.MAX_VALUE;
         int i =0, j = brr.length-1;

         while (i<arr.length && j >= 0) {
            int temp = arr[i] + brr[j];
            int difference = Math.abs(temp - x);
            if (difference < min) {
                min = difference;
                if (answer.size() == 0) {
                    answer.add(arr[i]);
                    answer.add(brr[j]);
                } else {
                    answer.set(0, arr[i]);
                    answer.set(1, brr[j]);
                }
            }
            if (temp < x) {
                i++;
            }else {
                j--;
            }
         }

        
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 7};
        int brr[] = {10, 20, 30, 40};
        int x = 32;
        List<Integer> answer = printClosest(arr, brr, x);
        System.out.println(Math.abs(answer.get(0)+answer.get(1)- x));
    }
}