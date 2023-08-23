package main 

import (
	"fmt"
)

func searchWord(arr [][]byte, str string) [][]int {
	var answer [][]int
	r := len(arr)
	c := len(arr[0])
	dir := [][]int{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}}
	for i:=0; i<r; i++ {
		for j:=0; j<c; j++ {
			if arr[i][j] == str[0] {
				for k:=0; k<8; k++ {
					tx, ty := i, j
					var temp int 
					for temp=1; temp<len(str); temp++ {
						x := tx + dir[k][0]
						y := ty + dir[k][1]
						if x<0 || y<0 || x>=r || y>=c || arr[x][y] != str[temp] {
							break;
						}
						tx = x
						ty = y
					}
					if (temp == len(str)) {
						answer =append(answer, []int{i, j})
					}
				}
			}
		}
	}
	return answer
}

func main() {
	str := "abc"
	arr := [][]byte{{'a', 'b', 'c'}, {'d', 'r', 'f'}, {'g', 'h' , 'i'}}
	fmt.Println(searchWord(arr, str))
}