package main

import (
	"fmt"
	"sort"
)

func create(n int, mat [][]int) [][]int {
	adj := make([][]int, 0)
	for i:=0; i<n; i++ {
		adj = append(adj, make([]int, 0))
	}
	for _,v := range mat {
		adj[v[0]] = append(adj[v[0]], v[1])
	}
	return adj
}

func eventualSafeNodes(n int, adj [][]int) []int {
	rev := make([][]int, n)
	for i:=0; i<n; i++ {
		rev[i] = make([]int, 0)
	}
	id := make([]int, n)
	for i:=0; i<n; i++ {
		for _,v := range adj[i] {
			rev[v] = append(rev[v], i)
			id[i]++
		}
	}
	queue := make([]int, 0)
	answer := make([]int, 0)
	for i:=0; i<n; i++ {
		if id[i] == 0 {
			queue = append(queue, i)
		}
	}
	for len(queue) > 0 {
		temp := queue[0]
		queue = queue[1:]
		answer = append(answer, temp);
		for _,n := range rev[temp] {
			id[n]--
			if id[n] == 0 {
				queue = append(queue, n)
			}
		}
		sort.Ints(answer)
	}
	return answer
}


func main() {
	n1 := 7;
	mat1 := [][]int{ {0,1},{0,2}, {1,2}, {1,3}, {2,5}, {3,0}, {4,5}}
	n2 := 4;
	mat2 := [][]int{{0,1}, {1,2}, {2,0}, {2,3}}
	adj1 := create(n1, mat1)
	adj2 := create(n2, mat2)
	// fmt.Println(adj1)
	// fmt.Println(adj2)
	fmt.Println(eventualSafeNodes(n1, adj1))
	fmt.Println(eventualSafeNodes(n2, adj2))
}