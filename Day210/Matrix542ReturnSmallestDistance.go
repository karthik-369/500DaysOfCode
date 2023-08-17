package main 

import (
	"fmt"
)

type Pair struct {
	first, second,  dist int
}

func updateMatrix(arr [][]int) [][]int {
	r := len(arr)
	c := len(arr[0])
	distance := make([][]int, r)
	visited := make([][]bool, r)
	for i:=0; i<r; i++ {
		distance[i] = make([]int, c)
		visited[i] = make([]bool, c)
	}
	queue := make([]Pair, 0)
	dir := [][]int{{-1,0},{1,0},{0,1},{0,-1}}
	for i:=0; i<r; i++ {
		for j:=0; j<c; j++ {
			if arr[i][j] == 0 {
				queue = append(queue, Pair{i, j, 0})
				visited[i][j] = true
			}
		}
	}
	for len(queue) > 0 {
		temp := queue[0]
		queue = queue[1:]
		distance[temp.first][temp.second] = temp.dist
		for i:=0; i<len(dir); i++ {
			row := temp.first + dir[i][0];
			col := temp.second + dir[i][1];
			if row >= 0 && col >= 0 && row < r && col < c && !visited[row][col] {
				queue = append(queue, Pair{row, col, temp.dist + 1})
				visited[row][col] = true
			}
		}
	}
	return distance
}

func main() {
	arr := [][]int{{0,0,0},{0,1,0},{1,1,1}}
	answer := updateMatrix(arr)
	for i:=0; i<len(answer); i++ {
		fmt.Println(answer[i])
	}
}