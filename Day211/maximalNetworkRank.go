package main

import (
	"fmt"
)

func maximumRank(arr [][]int , n int ) int {
	answer := 0
	con := make(map[int]map[int]struct{})
	for i:=0; i<n; i++ {
		con[i] = make(map[int]struct{})
	}
	for i:=0; i<len(arr); i++ {
		con[arr[i][0]][arr[i][1]] = struct{}{}
		con[arr[i][1]][arr[i][0]] = struct{}{}
	}
	for i:=0; i<n; i++ {
		for j:=i+1; j<n; j++ {
			temp := len(con[i]) + len(con[j])
			if _, found := con[i][j]; found {
				temp--
			}
			if temp > answer {
				answer = temp
			}
		}
	}
	return answer
}

func main() {
	arr := [][]int{{0,1},{0,3},{1,2},{1,3}}
	n := 4
	fmt.Println(maximumRank(arr, n))
}