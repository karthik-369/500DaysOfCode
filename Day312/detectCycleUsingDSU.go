package main

import (
	"fmt"
)

type DisjointSet struct {
	SIZE   []int
	PARENT []int
}

func newDisjointSet(n int) *DisjointSet {
	ds := &DisjointSet{}
	ds.SIZE = make([]int, n+1)
	ds.PARENT = make([]int, n+1)

	for i := 0; i <= n; i++ {
		ds.PARENT[i] = i
		ds.SIZE[i] = 1
	}
	return ds
}

func (ds *DisjointSet) findUParent(NODE int) int {
	if ds.PARENT[NODE] == NODE {
		return NODE
	}
	ds.PARENT[NODE] = ds.findUParent(ds.PARENT[NODE])
	return ds.PARENT[NODE]
}

func (ds *DisjointSet) unionBySize(NODE_1, NODE_2 int) {
	prnt_1 := ds.findUParent(NODE_1)
	prnt_2 := ds.findUParent(NODE_2)
	if prnt_1 == prnt_2 {
		return
	}
	if ds.SIZE[prnt_1] < ds.SIZE[prnt_2] {
		ds.PARENT[prnt_1] = prnt_2
		ds.SIZE[prnt_2] += ds.SIZE[prnt_1]
	} else {
		ds.PARENT[prnt_2] = prnt_1
		ds.SIZE[prnt_1] += ds.SIZE[prnt_2]
	}
}

func detectCycle(V int, adj [][]int) int {
	ds := newDisjointSet(V)
	st := make(map[[2]int]struct{})

	for i := 0; i < V; i++ {
		for j := 0; j < len(adj[i]); j++ {
			u := adj[i][j]
			key := [2]int{i, u}
			if ds.findUParent(u) == ds.findUParent(i) && st[key] {
				return 1
			} else {
				ds.unionBySize(i, u)
				st[key] = struct{}{}
				st[[2]int{u, i}] = struct{}{}
			}
		}
	}
	return 0
}

func main() {
	var V, E int
	fmt.Scan(&V)
	fmt.Scan(&E)

	adj := make([][]int, V)
	for i := 0; i < V; i++ {
		adj[i] = make([]int, 0)
	}

	for i := 0; i < E; i++ {
		var u, v int
		fmt.Scan(&u)
		fmt.Scan(&v)
		adj[u] = append(adj[u], v)
		adj[v] = append(adj[v], u)
	}

	result := detectCycle(V, adj)
	fmt.Println(result)
}
