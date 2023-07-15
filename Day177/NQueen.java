import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static List< List< Integer > > nQueens(int n)
    {
        // Write your code here.
        List<List<Integer>> answer = new ArrayList<>();
        if(n==1){
            answer.add(new ArrayList<>());
            answer.get(0).add(1);
            return answer;
            
        }
        if(n<=3&&n>1){
            return new ArrayList<>();
        }
        
        int board[][] = new int[n][n];
        dfs(0, board, answer);
        return answer;
    }
    public static void dfs(int row, int[][] board, List<List<Integer>> answer){
        if(row == board.length){
            answer.add(build(board));
            return;
        }
        for(int i=0;i<board.length;i++){
            if(safe(row, board, i)){
                board[row][i] = 1;
                dfs(row+1, board, answer);
                board[row][i] = 0;
            }
        }
    }
    public static boolean safe(int row, int[][] board, int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]==1){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        for(int i=row-1, j=col+1;j<board.length&&i>=0;j++,i--){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }
    public static List<Integer> build(int[][] board){
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j] == 1){
                    temp.add(1);
                }else{
                    temp.add(0);
                }
            
            }
        }
        return temp;
    }
}