package Day270;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class makingALargeIsland{
    Map<Integer, Integer> map = new HashMap<>();
    public int dir[][] = {{-1,0},{0,-1}, {1,0},{0,1}};
    public int largestIsland(int N,int[][] grid) 
    {
        // code here
        int gp[][] = new int[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(gp[i], -1);
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j] == 1 && gp[i][j] == - 1) {
                    set(gp, grid, i, j, i*N+j, N);
                }
            }
        }
        int answer = 0;
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> dp = new HashSet<>();
                    for (int d[]: dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (valid(x, y, N) && grid[x][y] == 1 && !dp.contains(gp[x][y])) {
                            dp.add(gp[x][y]);
                        }
                    }
                    int temp = 0;
                    for (int t: dp) {
                        temp += map.get(t);
                    }
                    answer = Math.max(answer, temp + 1);
                } else {
                    answer = Math.max(answer, map.get(gp[i][j]));
                }
            }
        }
        return answer;
    }
    public int set(int[][] gp, int[][] grid, int i, int j, int p, int N) {
        gp[i][j] = p;
        int count = 1;
        for (int d[] : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (valid(x, y, N) && grid[x][y] == 1 && gp[x][y] == -1) {
                count += set(gp, grid, x, y, p, N);
            }
        }
        map.put(p, count);
        return count;
    }
    public boolean valid(int i, int j, int N) {
        if (i>=N || i<0 || j>=N ||j<0) {
            return false;
        }
        return true;
    }
}
