package Day202;

import java.util.Arrays;

public class minimizeTheMaximumDistanceOfPairs{
    public static void main(String[] args){
        int arr[] = {10, 1, 2 ,7 ,1 ,3};
        int p = 2;
        System.out.println(minimizeMax(arr, p));
    }
    public static int valid(int nums[], int n){
        int temp = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]<=n){
                temp++;
                i++;
            }
            
        }
        return temp;
    }
    public static int minimizeMax(int[] nums, int p) {
        if(p==0){
            return 0;
        }
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1] - nums[0];
        int answer = 0;
        while(low<=high){
            int mid = high - ((high-low)>>1);
            if(valid(nums, mid)>=p){
                answer =  mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return answer;
    }
}