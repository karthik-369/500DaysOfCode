package Day276;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class maximumScoreOfAGoodSubarray {

    public static int maximumScore(int nums[], int k) {
        int low = k , high = k;
        int min = nums[k];
        int answer = nums[k];
        while (low>0 || high<nums.length-1) {
            if (low == 0 || (high<nums.length-1 && nums[high+1]>nums[low-1])) {
                high++;
            } else {
                low--;
            }
            min = Math.min(Math.min(min, nums[low]), nums[high]);
            answer = Math.max(answer, min*(high-low+1));
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {

        int k1 = 3;
        int k2 = 0;
        int k3 = 25330;
        int nums1[] = {1,4,3,7,4,5};
        int nums2[] = {5,5,4,5,4,1,1,1};
        
        FileReader file = new FileReader("C:/Users/karth/Desktop/500DaysOfCode/Day276/nums3.txt");
        int i;
        StringBuilder sb = new StringBuilder();
        while ((i=file.read())!=-1){
            sb.append((char)i);
        }
        file.close();
        String n3 = new String(sb);
        String n[] = n3.split(",");
        int nums3[] = new int[n.length];
        for (int j=0; j<n.length; j++) {
            nums3[j] = Integer.valueOf(n[j]); 
        }
        System.out.println(maximumScore(nums1, k1));
        System.out.println(maximumScore(nums2, k2));
        System.out.println(maximumScore(nums3, k3));
        // System.out.println(Arrays.toString(nums3));
    }
}