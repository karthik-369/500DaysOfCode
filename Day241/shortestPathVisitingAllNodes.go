package main

import (
	"fmt"
	"math"
)

func min(a int , b int ) int {
	if a < b {
		return a
	}
	return b
}

func shortestPathLength(graph [][]int) int {
	answer := math.MaxInt
	n := len(graph)
	dp := make([][]int, 1<<n)
	for i:=0; i<1<<n; i++ {
		dp[i] = make([]int, n)
		for j:=0; j<n; j++ {
			dp[i][j] = math.MaxInt
		}
	}	
	for i:=0; i<n; i++ {
		dp[1<<i][i] = 0
	}
	queue := [][]int{}
	for i:=0; i<n; i++ {
		queue = append(queue, []int{1<<i, i})
	}
	for len(queue) > 0 {
		temp := queue[0]
		queue = queue[1:]
		mask := temp[0]
		u := temp[1]
		for _,v :=range graph[u] {
			nm := mask |  (1<<v)
			if dp[nm][v] == math.MaxInt {
				dp[nm][v] = dp[mask][u] + 1
				queue = append(queue, []int{nm, v})
			}
		}
	}
	for i:=0; i<n; i++ {
		answer = min(answer, dp[(1<<n)-1] [i])
	}
	return answer
}

func main() {
	arr1 := [][]int{{1,2,3},{0},{0},{0}}
	arr2 := [][]int{{1},{0,2,4},{1,3,4},{2},{1,2}}
	fmt.Println(shortestPathLength(arr1))
	fmt.Println(shortestPathLength(arr2))
}

