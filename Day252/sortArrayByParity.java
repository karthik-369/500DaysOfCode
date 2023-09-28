package Day252;

import java.util.Arrays;

public class sortArrayByParity{

    public static int[] sabp (int nums[]) {
        int point = 0;
        for (int i=0; i<nums.length; i++) {
            if ((nums[i] & 1) != 1) {
                int temp = nums[point];
                nums[point++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums [] = {3,1,2,4};
        System.out.println(Arrays.toString(sabp(nums)));
    } 
}