package Day203;



class Solution {
    public boolean search(int[] nums, int target) {
       int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = high - ((high - low) >> 1);
            if(nums[mid] == target)
                return true;
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low++;
                high--;
            }
            else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else{
                if(target <= nums[high] && target > nums[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }

    
}

public class rotatedSearchII{
    public static void main(String[] args){
        int arr[] = {2,5,6,0,0,1,2};
        Solution sol = new Solution();
        System.out.println(sol.search(arr, 0));
    }
}