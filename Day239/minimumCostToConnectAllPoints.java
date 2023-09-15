package Day239;

import java.util.Arrays;

public class minimumCostToConnectAllPoints {
    
    public static int minKey(int[] key, boolean[] visited) {
        int minI = -1;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<key.length; i++) {
            if (!visited[i] && min>key[i]) {
                min = key[i];
                minI = i;
            }
        }
        return minI;
    }  

    public static int prim(int[][] mat, int n  ) {
        int answer = 0;
        int key[] = new int[n];
        int parent[] = new int[n];
        boolean visited[] = new boolean[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;
        
        for (int i=0; i<n-1; i++) {
            int u = minKey(key, visited);
            visited[u] = true;
            for (int v=0; v<n; v++) {
                if (mat[u][v] !=0 && !visited[v] && mat[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = mat[u][v];
                }
            }
        }
        
        for (int i=1; i<n; i++) {
            answer += mat[i][parent[i]];
        }
        System.out.println(Arrays.toString(key));
        System.out.println(Arrays.toString(parent));
        return answer;
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int mat[][] = new int[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j) {
                    mat[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                }
            }
        }
        // for (int i=0; i<n; i++) {
        //     System.out.println(Arrays.toString(mat[i]));
        // }
        return prim(mat, n);
    }

    public static void main(String[] args) {
        int arr[][] = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(arr));
    }

}