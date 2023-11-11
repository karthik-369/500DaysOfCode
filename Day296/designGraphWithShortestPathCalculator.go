import (
    "container/heap"
    "fmt"
)

type PriorityQueue []*Pair

func (pq PriorityQueue) Len() int {return len(pq)}
func (pq PriorityQueue) Less(i, j int) bool {return pq[i].c < pq[j].c}
func (pq PriorityQueue) Swap(i, j int) {pq[i], pq[j] = pq[j], pq[i]}
func (pq *PriorityQueue) Push(x interface{}) {*pq = append(*pq, x.(*Pair))}
func (pq *PriorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    x := old[n-1]
    *pq = old[0:n-1]
    return x
}
type Pair struct {
    e, c int
}

type Graph struct {
    adj [][]Pair
}


func Constructor(n int, edges [][]int) Graph {
    t := make([][]Pair, n)
    for i:=0; i<n; i++ {
        t[i] = make([]Pair, 0)
    }
    for _, edge:= range edges {
        u, v, w := edge[0], edge[1], edge[2]
        t[u] = append(t[u], Pair{v,w})
    }
    return Graph{t}
}


func (this *Graph) AddEdge(edge []int)  {
    u, v, w := edge[0], edge[1], edge[2]
    this.adj[u] = append(this.adj[u], Pair{v,w})
}


func (this *Graph) ShortestPath(node1 int, node2 int) int {
    dist:= make([]int, len(this.adj))
    for i:= range dist {
        dist[i] = math.MaxInt;
    }

    minHeap := &PriorityQueue{}
    heap.Init(minHeap)
    dist[node1] = 0
    heap.Push(minHeap, &Pair{e:node1, c:dist[node1]})
    for minHeap.Len() > 0 {
        temp := heap.Pop(minHeap).(*Pair)
        tn  := temp.e
        tc := temp.c
        if dist[tn] < tc {
            continue
        }
        for _, n := range this.adj[tn] {
            nc := dist[tn] + n.c;
            if nc < dist[n.e] {
                dist[n.e] = nc
                heap.Push(minHeap, &Pair{e: n.e, c: nc})
            }
        }
    }
        
    if dist[node2] == math.MaxInt {
            return -1
        }
        return dist[node2]
}


/**
 * Your Graph object will be instantiated and called as such:
 * obj := Constructor(n, edges);
 * obj.AddEdge(edge);
 * param_2 := obj.ShortestPath(node1,node2);
 */