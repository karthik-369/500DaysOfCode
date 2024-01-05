func onesMinusZeros(grid [][]int) [][]int {
    r, c := len(grid), len(grid[0])
    row1 := make([]int, r)
    col1 := make([]int, c)
    for i:=0; i<r; i++ {
        for j:=0 ;j<c; j++ {
            if grid[i][j] == 1 {
                row1[i]++
                col1[j]++
            }
        }
    }
    // fmt.Println(row1)
    // fmt.Println(col1)
    
    for i:=0; i<r; i++ {

        for j:=0; j<c; j++ {
            grid[i][j] = row1[i] + col1[j] - (r-row1[i]) - (c-col1[j]) 
        }
    }
    return grid
}