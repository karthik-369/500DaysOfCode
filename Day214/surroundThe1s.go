package  main

import (
	"fmt"
)

func countMatrix(arr [][]int) int {
	answer := 0
	r := len(arr)
	c := len(arr[0])
	dir := [][]int{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}}
	for i:=0; i<r; i++ {
		for j:=0; j<c; j++{
			oc := 0
			if arr[i][j] == 1 {
				for t:=0; t<8; t++ {
					x := i + dir[t][0]
					y := j + dir[t][1]
					if x>=0 && y >=0 && x<r && y<c && arr[x][y] == 0 {
						oc++
					}
				}
			}
			if oc!=0 && oc%2 == 0 {
				answer++
			}
		}
	}
	return answer
}

func main() {
	arr := [][]int{{1,0,0},{1,1,0},{0,1,0}}
	fmt.Println(countMatrix(arr))
}
