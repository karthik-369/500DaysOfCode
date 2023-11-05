package main

import (
	"container/heap"
	"fmt"
)

type Item struct {
	value int
	count int
}

type PriorityQueue []*Item

func (pq PriorityQueue) Len() int {
	return len(pq)
}

func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].count > pq[j].count || (pq[i].count == pq[j].count && pq[i].value < pq[j].value)
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
	item := x.(*Item)
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[0 : n-1]
	return item
}

func topKFrequent(nums []int, k int) []int {
	count := make(map[int]int)
	for _, num := range nums {
		count[num]++
	}

	pq := make(PriorityQueue, len(count))
	i := 0
	for num, c := range count {
		pq[i] = &Item{value: num, count: c}
		i++
	}
	heap.Init(&pq)

	result := make([]int, k)
	for i := 0; i < k; i++ {
		item := heap.Pop(&pq).(*Item)
		result[i] = item.value
	}

	return result
}

func main() {
	var T int
	fmt.Scan(&T)

	for T > 0 {
		var n, k int
		fmt.Scan(&n)
		nums := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Scan(&nums[i])
		}
		fmt.Scan(&k)

		result := topKFrequent(nums, k)
		for i := 0; i < len(result); i++ {
			fmt.Print(result[i], " ")
		}
		fmt.Println()
		T--
	}
}
