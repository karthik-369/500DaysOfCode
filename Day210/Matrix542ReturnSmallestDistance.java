package Day210;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    int first, second, dist;
    public Pair(int first, int second, int dist) {
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
}

public class Matrix542ReturnSmallestDistance {

    public static int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat.length;
        int distance[][] = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        Queue<Pair> queue = new LinkedList<>();
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            distance[temp.first][temp.second] = temp.dist;
            for (int i=0;i<4;i++) {
                int row = temp.first+ dir[i][0];
                int col = temp.second+ dir[i][1];
                if(row>=0 && col>=0 && row<r && col<c && !visited[row][col]) {
                    queue.offer(new Pair(row, col, temp.dist+1));
                    visited[row][col] = true;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int arr[][] = {{0,0,0},{0,1,0},{1,1,1}};
        int answer[][] = updateMatrix(arr);
        for(int i=0;i<answer.length;i++){
            System.out.println(Arrays.toString(answer[i]));
        }
    }
}