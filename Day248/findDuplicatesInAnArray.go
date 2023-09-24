package main 

import (
	"fmt"
)

func duplicates(arr []int, n int) []int {
	answer := make([]int, 0)
	for _,v := range arr {
		arr[v % n] = arr[v%n] +n
	}

	for i,v := range arr {
		if v >= 2 * n {
			answer = append(answer, i)
		}
	}
	if len(arr) == 0 {
		answer = append(answer, -1)
	}
	return answer
}

func main() {
	arr := []int{2,3,1,2,3}
	n := 5
	fmt.Println(duplicates(arr, n))
}