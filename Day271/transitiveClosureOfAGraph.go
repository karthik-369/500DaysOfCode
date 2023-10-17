package main

import (
	"fmt"
)

func transitiveClosure(n int, graph [][]int) [][]int {
	answer:= make([][] int, n)
	for i:= range answer {
		answer[i] = make([]int, n) 
		for j:=range answer[i] {
			answer[i][j] = graph[i][j]
		}
	}
	for k:=0; k<n; k++ {
		for i:=0; i<n; i++ {
			for j:=0; j<n; j++ {
				if answer[i][j] !=0 || ((answer[i][k] !=0) && (answer[k][j] != 0)) {
					answer[i][j] = 1
				}
			}
		}
	}
	return answer
}

func tcDfs(n int, graph [][]int) [][]int {
	adj := make([][]int, 0);
	answer := make([][]int, n)
	for i:=0; i<n; i++ {
		adj = append(adj, make([]int, 0))
		answer[i] = make([]int ,n)
		for j:=0; j<n; j++ {
			answer[i][j] = graph[i][j]
			if graph[i][j] == 1 {
				adj[i] = append(adj[i], j)
			}
		}
	}
	for i:=0; i<n; i++ {
		dfs(i, i, make([]bool, n), adj, answer)
	}
	return answer
} 

func dfs(i int, j int, visited []bool, adj [][]int, answer [][]int) {
	answer[i][j] = 1
	visited[j] = true
	for _,n := range adj[j] {
		if !visited[n] {
			dfs(i, n, visited, adj, answer)
		}
	}
}

func main() {
	n1 := 3;
	graph1 := [][]int{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
	n2 := 4;
	graph2 := [][]int{{1, 1, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}};
	fmt.Println(transitiveClosure(n1, graph1));
	fmt.Println(transitiveClosure(n2, graph2));
	fmt.Println(tcDfs(n1, graph1));
	fmt.Println(tcDfs(n2, graph2));
}