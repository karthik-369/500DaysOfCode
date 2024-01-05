class Solution {
    public int minOperations(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int v: nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for (int key: map.keySet()) {
            int temp = map.get(key);
            if (temp == 1) {
                return -1;
            }
            answer += temp / 3;
            if (temp %3 != 0) {
                answer++;
            }
        }
        return answer;
    }
}