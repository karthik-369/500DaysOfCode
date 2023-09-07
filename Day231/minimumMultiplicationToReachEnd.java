class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int[] dp = new int[100001];
        Arrays.fill(dp, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dp[start] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == end) {
                return dp[curr];
            }
            for (int i=0; i<arr.length; i++) {
                int temp = (curr * arr[i]) % 100000;
                if (dp[temp] == -1) {
                    dp[temp] = dp[curr] + 1;
                    queue.offer(temp);
                }
            }
        }
        return -1;
    }
}