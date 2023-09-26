package Day250;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Arrays;

public class findAllFourSumNumbers {

    public static List<List<Integer>> fourSum(int arr[], int k) {

        Set<List<Integer>> answer = new LinkedHashSet<>();

        Arrays.sort(arr);

        for (int i=0; i<arr.length-3; i++) {
            for (int j=i+1; j<arr.length-2; j++) {
                int l = j+1;
                int h = arr.length-1;

                while (l<h) {
                    int temp = arr[i] + arr[j] + arr[l] + arr[h];
                    if (temp == k) {
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[l]);
                        list.add(arr[h]);
                        answer.add(list);
                        l++;
                        h--;
                    } else if (temp > k) {
                        h--;
                    } else {
                        l++;
                    }
                }

            }
        }

        return new ArrayList<>(answer);

    }

    public static void main(String[] args) {

        int arr1[] = {0,0,2,1,1};
        int arr2[] = {10,2,3,4,5,7,8};
        int k1 = 3;
        int k2 = 23;

        System.out.println(fourSum(arr1, k1));
        System.out.println(fourSum(arr2, k2));

    }

}