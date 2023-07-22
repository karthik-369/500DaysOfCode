class Solution {
    
    
    public double knightProbability(int n, int k, int row, int column) {
        double[][] board = new double[n][n];
        double[][] state = new double[n][n];
        int dir[][] = {{-2,-1},{-1,-2},{2,-1},{-1,2},{2,1},{1,2},{-2,1},{1,-2}};
        board[row][column] = 1;
        for(int m=1;m<=k;m++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]!=0){
                        int x=0;
                        int y=0;
                        for(int d[]: dir){
                            x = i + d[0];
                            y = j + d[1];
                            if(x>=0 && y>=0 && x<n && y<n){
                                state[x][y] += board[i][j]/8.0;
                            }
                        }
                        
                    }
                }
            }
            board = state;
            state = new double[n][n];
        }
        double answer=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer+= board[i][j];
            }
        }
        return answer;
    }
}