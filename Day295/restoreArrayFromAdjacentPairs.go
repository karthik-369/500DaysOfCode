class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
       
        Map<Integer, int[]> map = new HashMap<>();
        for (int i=0; i<adjacentPairs.length; i++) {
            if (map.containsKey(adjacentPairs[i][0])) {
                map.get(adjacentPairs[i][0])[1] = adjacentPairs[i][1];
            } else {
                map.put(adjacentPairs[i][0], new int[]{adjacentPairs[i][1], Integer.MIN_VALUE});
            }  
            if (map.containsKey(adjacentPairs[i][1])) {
                map.get(adjacentPairs[i][1])[1] = adjacentPairs[i][0];
            } else {
                map.put(adjacentPairs[i][1], new int[]{adjacentPairs[i][0], Integer.MIN_VALUE});
            }
        }
        int answer[] = new int[adjacentPairs.length+1];
        int start = Integer.MIN_VALUE;
        for (int key: map.keySet()) {
            if (map.get(key)[1] == Integer.MIN_VALUE) {
                start = key;
            }
        }
        answer[0] = start;
        int prev = Integer.MIN_VALUE;
        for (int i=1; i<answer.length; i++) {
            int temp[] = map.get(start);
            int g = temp[0] == prev?temp[1]:temp[0];
            answer[i] = g;
            prev = start;
            start = g;
        }
        return answer;
    }
}