package main

import (
	"fmt"
	"math"
)

func minimumTime(n int, relations [][]int, time []int) int {
	graph := make(map[int][]int )
	queue := make([]int,0)
	id := make([]int, n+1)
	for _,v := range relations {
		graph[v[0]] = append(graph[v[0]], v[1])
		id[v[1]]++
	}
	temp := make([]int, n+1)
	copy(temp[1:], time)
	for i:=1; i<=n; i++ {
		if id[i] == 0 {
			queue = append(queue, i)
		}
	}
	for len(queue) > 0 {
		t := queue[0]
		queue= queue[1:]
		for _, neighbour := range graph[t] {
			temp[neighbour] =int(math.Max(float64(temp[neighbour]), float64(temp[t]+time[neighbour-1])))
			id[neighbour]--
			if id[neighbour] == 0 {
				queue = append(queue, neighbour)
			}
		}
	}
	max  := 0
	for _,v := range temp {
		max = int(math.Max(float64(max), float64(v)))
	}
	return max
}

func main() {
	n1 := 3
	relations1 := [][]int{{1,3}, {2,3}}
	time1 := []int{3,2,5}
	n2 := 5
	relations2 := [][]int{{1,5}, {2,5}, {3,5}, {3,4}, {4,5}}
	time2 := []int{1,2,3,4,5}
	fmt.Println(minimumTime(n1, relations1, time1))
	fmt.Println(minimumTime(n2, relations2, time2))
}