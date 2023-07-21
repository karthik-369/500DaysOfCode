class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int count[] = new int[n];
        int max = 1;
        Arrays.fill(arr, 1);
        Arrays.fill(count, 1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && arr[j]+1> arr[i]){
                    arr[i] = arr[j]+1;
                    count[i] = count[j];
                }else if(nums[j]<nums[i] && arr[j]+1==arr[i]){
                    count[i] += count[j];
                }
            }
            max = Math.max(max, arr[i]);
        }
        int length = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == max){
                length+=count[i];
            }
        }
        return length;
    }
}