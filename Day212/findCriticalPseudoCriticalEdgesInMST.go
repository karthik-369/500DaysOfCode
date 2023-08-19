package main

import (
	"fmt"
	"sort"
)

func findCriticalAndPseudoCriticalEdges(n int, e [][]int) [][]int {
	edges := make([][]int, len(e))
	parent := make([]int, n)
	size := make([]int, n)
	ans := make([][]int, 2)
	l1 := []int{}
	l2 := []int{}

	for i := 0; i < len(e); i++ {
		edges[i] = make([]int, 4)
		edges[i][0] = e[i][0]
		edges[i][1] = e[i][1]
		edges[i][2] = e[i][2]
		edges[i][3] = i
	}

	sort.Slice(edges, func(i, j int) bool {
		return edges[i][2] < edges[j][2]
	})

	minW := graph(edges, parent, size, -1, -1)

	for i := 0; i < len(e); i++ {
		w := graph(edges, parent, size, i, -1)

		if w == -1 {
			l1 = append(l1, i)
			continue
		}

		if w == minW {
			x := graph(edges, parent, size, -1, i)
			if x == w {
				l2 = append(l2, i)
			}
		} else if w > minW {
			l1 = append(l1, i)
		}
	}
	ans[0] = l1
	ans[1] = l2

	fmt.Println(minW)
	return ans
}

func graph(edges [][]int, parent, size []int, skip, include int) int {
	for i := 0; i < len(parent); i++ {
		parent[i] = i
		size[i] = 0
	}
	w := 0
	if include != -1 {
		for i := 0; i < len(edges); i++ {
			if edges[i][3] != include {
				continue
			}
			if p(edges[i][0], parent) == p(edges[i][1], parent) {
				continue
			} else {
				DSU(edges[i][0], edges[i][1], parent, size)
				w += edges[i][2]
			}
		}
	}

	for i := 0; i < len(edges); i++ {
		if edges[i][3] == skip {
			continue
		}
		if p(edges[i][0], parent) == p(edges[i][1], parent) {
			continue
		} else {
			DSU(edges[i][0], edges[i][1], parent, size)
			w += edges[i][2]
		}
	}
	cnt := 0
	for i := 0; i < len(parent); i++ {
		if i == parent[i] {
			cnt++
		}
	}
	if cnt > 1 {
		return -1
	}

	return w
}

func DSU(e1, e2 int, parent, size []int) {
	e1 = p(e1, parent)
	e2 = p(e2, parent)
	if e1 == e2 {
		return
	}

	if size[e1] == size[e2] {
		size[e1]++
		parent[e2] = e1
	} else if size[e1] > size[e2] {
		parent[e2] = e1
	} else {
		parent[e1] = e2
	}

	return
}

func p(e int, parent []int) int {
	if e == parent[e] {
		return e
	}

	parent[e] = p(parent[e], parent)
	return parent[e]
}

func main() {
	// Provide your input values for n and e here
	n := 4
	e := [][]int{
		{0, 1, 1},
		{1, 2, 2},
		{2, 3, 3},
		{0, 3, 4},
	}

	result := findCriticalAndPseudoCriticalEdges(n, e)
	fmt.Println(result)
}
