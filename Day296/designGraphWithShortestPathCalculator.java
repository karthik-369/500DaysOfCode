class Pair {
    int e, c;
    public Pair(int e, int c) {
        this.e =e;
        this.c = c;
    }
}
class Graph {
    public List<List<Pair>> adj;
    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }  
        for (int e[]:edges) {
            addEdge(e);
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        int dist[] = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(pair->pair.c));
        dist[node1] = 0;
        priorityQueue.add(new Pair(node1, dist[node1]));
        while (!priorityQueue.isEmpty()) {
            Pair temp = priorityQueue.poll();
            int tn = temp.e;
            int tc = temp.c;
            if (dist[tn] < tc) {
                continue;
            }
            for (Pair n: adj.get(tn)) {
                int nc = dist[tn] + n.c;
                if (nc < dist[n.e]) {
                    dist[n.e] = nc;
                    priorityQueue.offer(new Pair(n.e, nc));
                }
            }
        }
        return dist[node2] == Integer.MAX_VALUE?-1:dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */