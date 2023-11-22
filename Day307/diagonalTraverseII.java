class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count  =0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for ( int i=0; i<nums.size(); i++) {
            for (int j=0; j<nums.get(i).size(); j++) {
                if (!map.containsKey(i+j)) {
                    map.put(i+j, new ArrayList<>());
                }
                map.get(i+j).add(nums.get(i).get(j));
                count++;
            }
        }
        int answer[] = new int[count];
        int i = 0;
        for (int k=0; k<map.size(); k++) {
            if (map.containsKey(k)) {
                for (int j=map.get(k).size()-1; j>=0;j--) {
                    answer[i++] = map.get(k).get(j);
                }
            }
        }
        return answer;
    }
}