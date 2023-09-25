package main

import (
	"container/heap"
	"fmt"
	"sort"
)

type MaxHeap []int

func (h MaxHeap) Len() int           { return len(h) }
func (h MaxHeap) Less(i, j int) bool { return h[i] > h[j] }
func (h MaxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MaxHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func maxCombinations(n, k int, A, B []int) []int {
	answer := make([]int, 0)

	// Sort arrays A and B in ascending order
	sort.Ints(A)
	sort.Ints(B)

	maxHeap := &MaxHeap{}

	heap.Init(maxHeap)

	// Iterate over the largest elements of A and B to get k maximum combinations
	for i := n - 1; i >= n-k; i-- {
		for j := n - 1; j >= n-k; j-- {
			temp := A[i] + B[j]
			if maxHeap.Len() < k {
				heap.Push(maxHeap, temp)
			} else {
				if temp > (*maxHeap)[0] {
					heap.Pop(maxHeap)
					heap.Push(maxHeap, temp)
				} else {
					break
				}
			}
		}
	}

	// Pop values from maxHeap and insert them at the beginning of the answer slice
	for maxHeap.Len() > 0 {
		answer = append([]int{heap.Pop(maxHeap).(int)}, answer...)
	}

	return answer
}

func main() {
	arr1 := []int{3, 2}
	arr2 := []int{1, 4}
	n1, k1 := 2, 2
	n2, k2 := 4, 3
	arr3 := []int{1, 4, 2, 3}
	arr4 := []int{2, 5, 1, 6}

	fmt.Println(maxCombinations(n1, k1, arr1, arr2)) // [7, 6]
	fmt.Println(maxCombinations(n2, k2, arr3, arr4)) // [10, 10, 10]
}
