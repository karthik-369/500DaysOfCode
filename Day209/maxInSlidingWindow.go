package main

import (
	"fmt"
	"container/list"
)

func maxSlidingWindow (arr []int, k int) []int {
	if k == 1 {
		return arr
	}
	answer := make([]int, len(arr) - k + 1)
	deque := list.New()
	for i:=0; i<len(arr); i++ {
		for deque.Len() > 0 && deque.Front().Value.(int) < i - k + 1 {
			deque.Remove(deque.Front())
		}
		for deque.Len() > 0 && arr[deque.Back().Value.(int)] < arr[i] {
			deque.Remove(deque.Back())
		}
		deque.PushBack(i)
		if i >= k - 1 {
			answer[i - k + 1] = arr[deque.Front().Value.(int)]
		}
 	}
	return answer
}

func main() {
	arr := []int{1,3,-1, -3, 5, 3, 6, 7}
	k := 3
	answer := maxSlidingWindow(arr, k)
	fmt.Println(answer)
}

