import (
	"container/heap"
	"math"
)

type Cell struct {
	x, y, d int
}

type PriorityQueue []Cell

func (pq PriorityQueue) Len() int           { return len(pq) }
func (pq PriorityQueue) Less(i, j int) bool { return pq[i].d < pq[j].d }
func (pq PriorityQueue) Swap(i, j int)      { pq[i], pq[j] = pq[j], pq[i] }

func (pq *PriorityQueue) Push(x interface{}) {
	*pq = append(*pq, x.(Cell))
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[0 : n-1]
	return item
}

func minimumEffortPath(heights [][]int) int {
	r := len(heights)
	c := len(heights[0])
	pq := make(PriorityQueue, 0)
	heap.Init(&pq)

	answer := make([][]int, r)
	for i := range answer {
		answer[i] = make([]int, c)
		for j := range answer[i] {
			answer[i][j] = math.MaxInt32
		}
	}

	dir := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	pq.Push(Cell{0, 0, 0})
	answer[0][0] = 0

	for len(pq) > 0 {
		cell := heap.Pop(&pq).(Cell)
		x := cell.x
		y := cell.y
		d := cell.d

		if x == r-1 && y == c-1 {
			return d
		}

		for _, di := range dir {
			i := x + di[0]
			j := y + di[1]
			if i >= 0 && j >= 0 && i < r && j < c {
				t := int(math.Max(float64(d), math.Abs(float64(heights[i][j]-heights[x][y]))))
				if t < answer[i][j] {
					answer[i][j] = t
					heap.Push(&pq, Cell{i, j, t})
				}
			}
		}
	}

	return answer[r-1][c-1]
}
