package main

import (
	"fmt"
)

func fib(n int) []int64 {
	answer := make([]int64, n)
	if n >= 1 {
		answer[0] = 1
	}
	if n >= 2 {
		answer[1] = 1
	}
	for i:=3; i<=n; i++ {
		answer[i-1] = answer[i-2] + answer[i-3]
	}
	return answer
}

func main() {
	n := 5
	fmt.Println(fib(n))
}