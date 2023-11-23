class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        for (int i=0; i<l.length; i++) {
            answer .add(isArr(nums, l[i], r[i]));
        }
        return answer;
    }
    public boolean isArr(int nums[], int l, int r) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=l ;i<=r; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int n = r - l  + 1;
        if ((max-min) %(n-1) != 0) {
            return false;
        }
        int diff = (max - min) / (n - 1);
        if (diff == 0) {
            return true;
        }
        boolean visited[] = new boolean[n];
        for (int i=l; i<=r; i++) {
            int v = nums[i];
            if ((v - min) %diff != 0) {
                return false;
            } else {
                int temp = (v - min) / diff;
                if (visited[temp] ) {
                    return false;
                }
                visited[temp] = true;
            }
        }
        return true;
    }
}