package Day243;

import java.util.Map;
import java.util.HashMap;

public class findDuplicateNumber {
    // SC => O(N)
    public static int findDuplicate(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if (map.containsKey(arr[i])) {
                return arr[i];
            } else {
                map.put(arr[i], 0);
            }
        }
        return -1;
    }
    // slow and fast (two) pointer method constant space 
    public static int find(int arr[]) {
        int slow = arr[0];
        int fast = arr[arr[0]];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        fast = 0;
        while (fast != slow) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
    // 2 methods that involves modification of array 
    //approach 1 to mark the elements with -ve symbol
    //approach 2 to place the elements with respect to their index
    public static int xor (int arr[]) {
        int answer = 0;
        for (int i=0; i<arr.length; i++) {
            answer = answer ^ arr[i];
        }
        for (int i=0; i<arr.length; i++) {
            answer = answer ^ i;
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr1[] = {1,3,4,2,2};
        int arr2[] = {3,1,3,4,2};
        int arr3[] = {2,2,2,2,2,2};
        System.out.println(findDuplicate(arr1));
        System.out.println(findDuplicate(arr2));
        System.out.println(findDuplicate(arr3));
        System.out.println(find(arr1));
        System.out.println(find(arr2));
        System.out.println(find(arr3));
        System.out.println(xor(arr1));
        System.out.println(xor(arr2));
        System.out.println(xor(arr3));
    }
}