package Day205;

import java.util.ArrayList;
import java.util.List;

public class uniquePathII {

    public static List<Integer> answer = new ArrayList<>();

    public static int   uniquePathsWithObstacles(int[][] grid){
        if(grid[0][0] == 1){
            return 0;
        }
        dfs(grid, 0, 0, grid.length, grid[0].length);
        System.out.println(answer);
        return answer.size();
    }

    public static void dfs(int[][] grid, int i, int j, int r, int c) {
        if(i == r-1 && j == c-1){
            System.out.println("from me");
            answer.add(0);
            return;
        }
        
        if(i+1 < r && grid[i+1][j]!=1) {
            
            dfs(grid, i+1, j, r, c);
        }
        if(j+1<c && grid[i][j+1]!=1) {
            
            dfs(grid, i, j+1, r, c);
        }
    }

    public static void main(String[] args) {
        int arr[][]= {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}