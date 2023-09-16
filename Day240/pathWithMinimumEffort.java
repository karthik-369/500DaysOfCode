//find safest path  in fa grid -- similar

package Day240;

import java.util.Arrays;
import java.util.PriorityQueue;

// class Pair {
//     int diff, x, y;
//     public Pair(int diff, int x, int y) {
//         this.diff = diff;
//         this.x = x;
//         this.y = y;
//     }
// }
// public class pathWithMinimumEffort {
    
//     public static int minimumEffortPath(int heights[][]) {
//         int r = heights.length;
//         int c = heights[0].length;
//         boolean visited[][] = new boolean[r][c];
//         int answer[][] = new int[r][c];
//         for (int i=0; i<r; i++) {
//             Arrays.fill(answer[i], Integer.MAX_VALUE);
//         }
//         answer[0][0] = 0;
//         int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.diff, b.diff));
//         pq.offer(new Pair(0,0,0));
//         while (!pq.isEmpty()) {
//             // System.out.println("froe me");
//             Pair temp = pq.poll();
//             int x = temp.x;
//             int y = temp.y;
//             if (x == r - 1 && y == c - 1) {
//                 return temp.diff;
//             }
//             if (visited[x][y]) {
//                 continue;
//             }
//             visited[x][y] = true;
//             for (int i=0; i<4; i++) {
//                 int nx = x + dir[i][0];
//                 int ny = y + dir[i][1];
//                 if (nx>=0 && ny >=0 && nx<r && ny<c) {
//                     int td = Math.max(temp.diff, Math.abs(heights[x][y] - heights[nx][ny]));
                    
//                     // System.out.println("froe me");
//                     if (td < answer[nx][ny]) {
//                         answer[ny][nx] = td;
//                         pq.offer(new Pair(td, nx, ny));
//                     }
//                 }
//             }
//         }
//         for (int i=0; i<r; i++) {
//             System.out.println(Arrays.toString(answer[i]));
//         }
//         return answer[r-1][c-1];
//     }

//     public static void main(String[] args) {
//         int arr[][] = {{1,2,2},{3,8,2},{5,3,5}};
//         System.out.println(minimumEffortPath(arr));
//     }
// }
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int answer[][] = new int[r][c];
        for (int []temp: answer) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        pq.offer(new int[]{0, 0, 0});
        answer[0][0] = 0;
        while (!pq.isEmpty()) {
            int temp[] = pq.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];
            if (x == r-1 && y == c - 1) {
                return d;
            }
            for (int di[]: dir) {
                int i = x + di[0];
                int j = y + di[1];
                if (i >=0 && j >=0 && i<r && j<c ) {
                    int t = Math.max(d, Math.abs(heights[i][j] - heights[x][y]));
                    if (t < answer[i][j]) {
                        answer[i][j] = t;
                        pq.offer(new int[]{i, j, t});
                    }
                }
            }
        }
        return answer[r-1][c-1];
    }
}