package Day241;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class shortestPathVisitingAllNodes {

    public static int shortestPathLength(int[][] graph) {
        int answer = Integer.MAX_VALUE;
        int n = graph.length;
        int dp[][] = new int[1<<n][n];
        for (int i=0; i<1<<n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i=0; i<n; i++) {
            dp[1<<i][i] = 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i=0; i<n; i++) {
            queue.offer(new int[]{1<<i, i});
        }
        while (!queue.isEmpty()){
            int temp[] = queue.poll();
            int mask = temp[0];
            int u = temp[1];
            for (int v : graph[u]) {
                int nm = mask | (1 <<v);
                if (dp[nm][v] == Integer.MAX_VALUE) {
                    dp[nm][v] = dp[mask][u] + 1;
                    queue.offer(new int[]{nm, v});
                }
            }
        }
        for (int i=0; i<n; i++) {
            answer = Math.min(answer, dp[(1<<n)-1][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr1[][] = {{1,2,3},{0},{0},{0}};
        int arr2[][] = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        System.out.println(shortestPathLength(arr1));
        System.out.println(shortestPathLength(arr2));
    }
}