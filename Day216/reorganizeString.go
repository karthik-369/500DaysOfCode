package main

import (
	"fmt"
	"container/heap"
)

type Pair struct {
	a, b int 
}

type PriorityQueue []Pair

func (pq PriorityQueue) Len() int {return len(pq)}
func (pq PriorityQueue) Less(i, j int) bool {return pq[i].a > pq[j].a}
func (pq PriorityQueue) Swap(i, j int) {pq[i], pq[j] = pq[j], pq[i]}

func (pq *PriorityQueue) Push(x interface{}) {
	*pq = append(*pq, x.(Pair))
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	x := old[n-1]
	*pq = old[0: n-1]
	return x
}

func reorganizeString(s string) string {
	var answer string 
	arr := make([]int , 26)
	len := len(s)
	priorityQueue := &PriorityQueue{}
	heap.Init(priorityQueue)
	for i:=0; i<len; i++ {
		temp := int(s[i]-'a')
		arr[temp]++
		if arr[temp] > (len+1)/2 {
			return ""
		}
	}
	for i:=0; i<26; i++ {
		if arr[i] !=0 {
			heap.Push(priorityQueue, Pair{a: arr[i], b:i})
		}
	}
	for priorityQueue.Len() >= 2 {
		temp1 := heap.Pop(priorityQueue).(Pair)
		temp2 := heap.Pop(priorityQueue).(Pair)
		answer += string(byte(temp1.b+97))
		answer += string(byte(temp2.b+97))
		if temp1.a > 1 {
			heap.Push(priorityQueue, Pair{a: temp1.a -1, b:temp1.b})
		}
		if temp2.a > 1 {
			heap.Push(priorityQueue, Pair{a: temp2.a -1, b:temp2.b})
		}
	}
	if priorityQueue.Len() > 0 {
		answer += string(byte(priorityQueue.Pop().(Pair).b+97))
	}
	return answer
}

func main() {
	str := "aab"
	fmt.Println(reorganizeString(str))
}