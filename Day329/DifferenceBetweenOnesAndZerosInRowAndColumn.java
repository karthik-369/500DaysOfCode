class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int row1[] = new int[r];
        int col1[] = new int[c];
        for (int i=0; i<r; i++) {
            for (int j=0 ;j<c; j++) {
                if (grid[i][j] == 1) {
                    row1[i]++;
                    col1[j]++;
                }
            }
        }
        // fmt.Println(row1)
        // fmt.Println(col1)
        
        for (int i=0; i<r; i++) {

            for (int j=0; j<c; j++) {
                grid[i][j] = row1[i] + col1[j] - (r-row1[i]) - (c-col1[j]); 
            }
        }
        return grid;
    }
}