class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;

        int[][] arr = new int[d][n];
        for (int i = 1; i < d; ++i) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        int max = 0;
        int i = 0;
        while (i <= n - d) {
            max = Math.max(max, jobDifficulty[i]);
            arr[0][i] = max;
            ++i;
        }

        int temp = 1;
        while (temp < d) {
            int t = temp;
            while (t <= n - d + temp) {
                int cj = jobDifficulty[t];
                int answer = Integer.MAX_VALUE;
                int j = t - 1;
                while (j >= temp - 1) {
                    answer = Math.min(answer, arr[temp - 1][j] + cj);
                    cj = Math.max(cj, jobDifficulty[j]);
                    --j;
                }
                arr[temp][t] = answer;
                ++t;
            }
            ++temp;
        }

        return arr[d - 1][n - 1];
    }
}