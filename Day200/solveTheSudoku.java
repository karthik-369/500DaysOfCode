package Day200;

public class solveTheSudoku{
    public static void main(String[] args){
        int board[][] = {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        int n = board.length;
        
        solveSudoku(board, n);
        print(board, n);
    }

    public static boolean solveSudoku(int[][]board, int n){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == 0){
                    for(int k = 1;k<10;k++){
                        if(safe(board, i, j, k)){
                            board[i][j] = k;
                            if(solveSudoku(board, n)){
                                return true;
                            }else{
                                board[i][j] = 0;
                            }
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;

    }
    public static void print(int board[][], int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println(board[i][8]);
        }
    }

    public static boolean safe(int[][] board, int r, int c, int num){
       
        for(int i=0;i<9;i++){
            if(board[i][c] == num){
                return false;
            }
            if(board[r][i]  == num){
                return false;
            }
            if(board[3 * (r/3)+i/3][3*(c/3)+i%3] == num){
                return false;
            }
        }
        return true;

    }

}