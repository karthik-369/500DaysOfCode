package main 

import (
	"fmt"
	"container/heap"
)

type IntHeap []int

func (h IntHeap) Len() int {return len(h)}
func (h IntHeap) Less(i, j int) bool {return h[i] > h[j]}
func (h IntHeap) Swap(i, j int) {h[i], h[j] = h[j], h[i]}

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0:n-1]
	return x
}

func minDel(s string) int {
	answer :=0
	fmap := make(map[byte]int)
	for i:=0; i<len(s); i++ {
		fmap[s[i]]++
	}
	priorityQueue := &IntHeap{}
	heap.Init(priorityQueue)
	for _, f := range fmap {
		heap.Push(priorityQueue, f)
	}
	for priorityQueue.Len() > 1 {
		temp := heap.Pop(priorityQueue).(int)
		if priorityQueue.Len()>0 && (*priorityQueue)[0] == temp && temp !=0 {
			answer++
			heap.Push(priorityQueue, temp - 1)
		}
	}
	return answer
}
func minDeletion(s string) int {
	answer := 0
	arr := make([]int, 26)
	for i:=0; i<len(s); i++ {
		arr[s[i]-'a']++
	}
	set := make(map[int]bool)
	for i:=0; i<26; i++ {
		temp := arr[i]
		for temp > 0 {
			if !set[temp] {
				set[temp] = true
				break
			}
			answer++
			temp--
		}
	}
	return answer
}

func main() {
	st := "aaabbbcc"
	fmt.Println(minDel(st))	
	fmt.Println(minDeletion(st))
}