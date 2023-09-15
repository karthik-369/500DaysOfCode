package main

import (
	"fmt"
	"math"
)

func minKey(key []int, visited []bool) int {
	var minI, min int = -1, math.MaxInt
	for i:=0; i<len(key); i++ {
		if !visited[i] && min > key[i] {
			min = key[i]
			minI = i
		}
	}
	return minI
}

func prim(mat [][]int, n int) int {
	var answer int = 0 
	key := make([]int , n)
	parent := make([]int, n)
	visited := make([]bool, n)
	for i:=0; i<n; i++ {
		key[i] = math.MaxInt
	}
	key[0] = 0
	parent[0] = -1
	for i:=0; i<n-1; i++ {
		u := minKey(key, visited)
		visited[u] = true
		for v:=0; v<n; v++ {
			if mat[u][v] != 0 && !visited[v] && mat[u][v] < key[v] {
				parent[v] = u
				key[v] = mat[u][v]
			}
		}
	}
	for i:=1; i<n; i++ {
		answer += mat[i][parent[i]]
	}
	return answer
}

func minCostConnectPoints(points [][]int) int {
	var n int = len(points)
	mat := make([][]int, n)
	for i:=0; i<n; i++ {
		mat[i] = make([]int, n)
		for j:=0; j<n; j++ {
			if i != j {
				mat[i][j] = int(math.Abs(float64(points[i][0] - points[j][0])) + math.Abs(float64(points[i][1] - points[j][1])))
			}
		}
	}
	return prim(mat, n)
}

func main() {
	arr := [][]int{{0,0},{2,2},{3,10},{5,2},{7,0}}
	fmt.Println(minCostConnectPoints(arr))
}
