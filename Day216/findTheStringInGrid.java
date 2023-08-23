package Day216;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class findTheStringInGrid {
    public static List<Pair> list = new ArrayList<>();
    public static int dir[][] = {{-1,-1},{-1,0},{-1,0},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static String str = "";
    public static int[][] searchWord(char grid[][], String word){
        int r = grid.length;
        int c = grid[0].length;
        boolean visited[][] = new boolean[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (word.charAt(0) == grid[i][j]) {
                    if (dfs(grid, i, j, r, c, visited, word)) {
                        list.add(new Pair(i, j));
                    }
                }
            }
        }
        if (list.size() == 0) {
            return new int[][]{{}};
        }
        int answer[][] = new int[list.size()][2];
        for (int i=0; i<list.size(); i++) {
            answer[i][0] = list.get(i).first;
            answer[i][1] = list.get(i).second;
        }
        return answer;
    }
    public static boolean dfs(char grid[][], int i, int j, int r, int c, boolean[][] visited, String word) {
       if (word.length() == 0) {
            return true;
       }
       if (i<0 || j<0 || i>=r || j>=c || grid[i][j]!=word.charAt(0)||visited[i][j]) {
            return false;
       }
       String temp = word.substring(1);
       visited[i][j] = true;
       boolean answer = dfs(grid, i-1, j-1, r, c, visited, temp);
       for (int k=1; k<8; k++) {
            answer |= dfs(grid, i+dir[k][0], j+dir[k][1], r, c, visited, temp);
       }
       visited[i][j] = false;
       return answer;
    }
    public static int[][] serach(char grid[][], String word) {
        int r = grid.length;
        int c = grid[0].length;
        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    for (int k=0; k<8; k++) {
                        int tx=i, ty = j;
                        int temp;
                        for (temp=1; temp<word.length(); temp++) {
                            int x = tx + dir[k][0];
                            int y = ty + dir[k][1];
                            if (x<0 || y<0 || x>=r || y>=r || grid[x][y]!=word.charAt(temp)) {
                                break;
                            }
                            tx = x;
                            ty = y;
                        }
                        if (temp == word.length()) {
                            list.add(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }
        int answer[][] = new int[list.size()][2];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        char grid[][] = {{'a', 'b', 'c'}, {'d', 'r', 'f'}, {'g', 'h' , 'i'}};
        String word = "abc";
        //And there is a condition that must be satisfied and it is to avoid zig-zag pattern
        // searchWord function doesn't tackle the condintion
        int answer[][] = searchWord(grid, word);
        //another function; // just check in horizontal/ vertical / diagonal
        int aanswer[][] = serach(grid, word);
        for(int i=0;i<aanswer.length;i++){
            System.out.println(Arrays.toString(aanswer[i]));
        }
    }
}