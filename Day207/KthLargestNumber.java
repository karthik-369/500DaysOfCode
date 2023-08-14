package Day207;

import java.util.Arrays;
import java.util.Random;

//O(K*N)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         int mi = 0;
//         int n = nums.length;
//         int answer = nums[0];
//         while(k != 0) {
//             int max = -10001;
//             for(int i=0; i<n; i++) {
//                 if(max<=nums[i]){
//                     max = nums[i];
//                     mi = i;
//                 }
//             }

//             answer = nums[mi];
//             nums[mi] = Integer.MIN_VALUE;
//             // System.out.println(Arrays.toString(nums));
//             k--;
//         }
//         return answer;
//     }
// }

public class KthLargestNumber {
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int findKthLargest(int arr[], int k) {
        
        k = arr.length -  k;
        //randomizing the array for quick select O(n)
        Random random = new Random();
        for (int i=arr.length-1; i>=0; i--) {
            int j = random.nextInt(i+1);
            swap(arr, i , j);
        }

        System.out.println(Arrays.toString(arr));

        return quickSelect(arr, 0, arr.length-1, k);
    }
    public static int quickSelect(int arr[], int start, int end, int k){
        int pivot = arr[end];
        int point = start;
        for (int i=start; i<end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, point);
                point++;
            }
        }
        swap(arr, point, end);
        System.out.println(Arrays.toString(arr));
        if (point>k){
            return quickSelect(arr, start, point -1, k);
        } else if (point<k) {
            return quickSelect(arr, point+1, end, k);
        } 
        return arr[point];
    }
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 5,6,4};
        int k = 1; 
        System.out.println(findKthLargest(arr, k));
    }
}