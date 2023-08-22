package main 

import (
	"fmt"
)

func makeMatrixBeautiful(arr [][]int) int {
	n, rs, cs, ts := len(arr), 0, 0, 0
	row, col := make([]int, n), make([]int, n)
	for i:=0; i<n; i++ {
		for j:=0; j<n; j++ {
			ts += arr[i][j]
			row[i] += arr[i][j];
			col[j] += arr[i][j];
		}
	}
	for i:=0; i<n; i++ {
		rs = max(rs, row[i])
		cs = max(cs, row[i])
	}
	
	return max(cs,rs) *n - ts

}

func main() {
	arr := [][]int{{1, 2, 3}, {4, 2, 3}, {3, 2, 1}}
	fmt.Println(makeMatrixBeautiful(arr))
}