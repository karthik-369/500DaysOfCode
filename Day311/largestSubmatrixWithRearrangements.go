func largestSubmatrix(matrix [][]int) int {
    answer := 0
    for i,v := range matrix {
        for j,_ := range v {
            if matrix[i][j] != 0 && i > 0 {
                matrix[i][j] += matrix[i-1][j]
            }
        }
        row := make([]int, len(v))
        copy(row, matrix[i])
        
        sort.Ints(row)
        for ind, val := range row {
            answer = int(math.Max(float64(answer), float64(val * (len(v) - ind))))
        }
    }

    return answer
}