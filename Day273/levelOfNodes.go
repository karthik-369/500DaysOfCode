package main 

import (
	"fmt"
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

func nodeLevel(n int, adj [][]int, x int) int  {
	queue := make([][]int, 0)
	visited := make([]bool, n)
	queue = append(queue, []int{0,0})
	visited[0] = true
	for len(queue) > 0 {
		temp := queue[0]
		queue = queue[1:]
		if temp[0] == x {
			return temp[1]
		}
		for _, v := range adj[temp[0]] {
			if !visited[v] {
				queue = append(queue, []int{v, temp[1]+1})
				visited[v] = true
			}
		}
	}
	return -1
}

func main() {
	n1 := 6;
	mat1 := [][]int{ {0,1},{0,2},{1,0}, {1,3}, {1,4},{2,0}, {2,5}, {3,1}, {4,1}, {5,2}};
	x1 := 4;
	n2 := 4;
	mat2 := [][]int{{0,1},{0,2},{0,3}, {1,0}, {2,0}, {3,0}};
	x2 := 1;
	adj1 := create(n1, mat1)
	adj2 := create(n2,mat2)
	fmt.Println(nodeLevel(n1, adj1, x1));
	fmt.Println(nodeLevel(n2, adj2, x2));
}