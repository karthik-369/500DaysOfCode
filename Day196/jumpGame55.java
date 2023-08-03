package Day196;
class Solution {
    public boolean canJump(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(count<i){
                return false;
            }
            if(count<i+nums[i]){
                count = i + nums[i];
            }
        }
        return true;
    }
}