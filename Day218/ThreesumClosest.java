package Day218;

import java.util.Arrays;

public class ThreesumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i=0; i<nums.length - 2; i++) {
            int j = i+1; 
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j]+nums[k];
                if (min>Math.abs(target - sum)) {
                    min = Math.abs(target-sum);
                    answer  = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int arr[] = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(arr, target));
    }
}