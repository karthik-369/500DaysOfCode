class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int temp[] = new int[nums.length+1];
        List<List<Integer>> answer = new ArrayList<>();
        for (int v: nums) {
            if (temp[v] >= answer.size()) {
                answer.add(new ArrayList<>());
            }
            answer.get(temp[v]).add(v);
            temp[v]++;
        }
        return answer;
    }

}
