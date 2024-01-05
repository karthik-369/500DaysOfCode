func transpose(matrix [][]int) [][]int {
    r, c := len(matrix), len(matrix[0])
    arr := make([][]int, c)
    for i:=0; i<c; i++ {
        arr[i] = make([]int, r)
        for j:=0; j<r; j++ {
            arr[i][j] = matrix[j][i]
        }
    }
    
    return arr
}