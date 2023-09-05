
func printGraph(V int, edges [][]int) [][]int {
	adj := make([][]int, V)

	for i := 0; i < V; i++ {
		adj[i] = []int{}
	}

	for i := 0; i < len(edges); i++ {
		adj[edges[i][0]] = append(adj[edges[i][0]], edges[i][1])
		adj[edges[i][1]] = append(adj[edges[i][1]], edges[i][0])
	}

	return adj
}
