package main

import (
	"container/heap"
	"fmt"
)

type Pair struct {
	first, second int
}

// PairHeap is a min heap implementation for Pair.
type PairHeap []Pair

func (h PairHeap) Len() int           { return len(h) }
func (h PairHeap) Less(i, j int) bool { return h[i].first < h[j].first }
func (h PairHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

// Push and Pop implement heap.Interface.
func (h *PairHeap) Push(x interface{}) {
	*h = append(*h, x.(Pair))
}

func (h *PairHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func buyMaximumProducts(n, k int, price []int) int {
	priorityQueue := make(PairHeap, 0)
	heap.Init(&priorityQueue)

	for i := 0; i < n; i++ {
		heap.Push(&priorityQueue, Pair{first: price[i], second: i + 1})
	}

	answer := 0
	sum := 0
	flag := false

	for len(priorityQueue) > 0 {
		temp := heap.Pop(&priorityQueue).(Pair)

		for i := temp.second; i >= 1; i-- {
			sum += temp.first * i
			if sum <= k {
				answer += i
				break
			} else {
				flag = true
				sum -= temp.first * i
			}
		}

		if flag {
			break
		}
	}

	return answer
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var n, k int
		fmt.Scan(&n, &k)

		price := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Scan(&price[i])
		}

		result := buyMaximumProducts(n, k, price)
		fmt.Println(result)

		t--
	}
}
