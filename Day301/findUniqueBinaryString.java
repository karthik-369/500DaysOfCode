class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int l = nums[0].length();
        int last = (int)Math.pow(2,l);
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        for (int i=last-1; i>=0; i--) {
            String check = Integer.toBinaryString(i);
            while (check.length()<l) {
                check ="0" +check;
            }
            // System.out.println(check);
            if (!set.contains(check)) {
                return check;
            }
        }
        return Integer.toBinaryString(nums.length);
    }
}