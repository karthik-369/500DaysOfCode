package main

import "fmt"

func findMotherVertex(V int, adj [][]int) int {
	visited := make([]bool, V)
	mother := 0

	for i := 0; i < V; i++ {
		if !visited[i] {
			mother = i
			dfs(i, visited, adj)
		}
	}

	visited = make([]bool, V)
	dfs(mother, visited, adj)

	for i := 0; i < V; i++ {
		if !visited[i] {
			return -1
		}
	}

	return mother
}

func dfs(i int, visited []bool, adj [][]int) {
	visited[i] = true
	for _, n := range adj[i] {
		if !visited[n] {
			dfs(n, visited, adj)
		}
	}
}

func main() {
	V := 5
	edges := [][]int{{1, 0}, {0, 2}, {2, 1}, {2, 3}, {3, 4}}

	adj := make([][]int, V)
	for i := 0; i < V; i++ {
		adj[i] = []int{}
	}

	for i := 0; i < len(edges); i++ {
		adj[edges[i][0]] = append(adj[edges[i][0]], edges[i][1])
	}

	mother := findMotherVertex(V, adj)
	fmt.Println(mother)
}
