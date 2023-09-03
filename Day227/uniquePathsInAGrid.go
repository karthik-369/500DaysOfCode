package main

import (
	"fmt"
)

func uniquePaths(m int, n int) int {
    N := n + m  - 2
    R := m - 1
    answer := 1
    for i:=1; i<=R; i++ {
        answer = answer *(N - R + i) / i
    }
    return answer
}

func main() {
	m := 3
	n := 7
	fmt.Println(uniquePaths(m, n))
}