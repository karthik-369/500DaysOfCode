package main

import (
	"fmt"
)

type Solution struct {
	answer []int
	n      int
}

func (sol *Solution) print(N int) {
	sol.answer = append(sol.answer, sol.n)
	if sol.n <= 0 {
		return
	}
	sol.n -= 5
	sol.print(N)
}

func (sol *Solution) nprint(N int) {
	sol.answer = append(sol.answer, sol.n)
	if sol.n >= N {
		return
	}
	sol.n += 5
	sol.nprint(N)
}

func (sol *Solution) pattern(N int) []int {
	sol.answer = make([]int, 0)
	if N == 0 {
		sol.answer = append(sol.answer, 0)
		return sol.answer
	}
	if N < 0 {
		sol.answer = append(sol.answer, N)
		return sol.answer
	}
	sol.n = N
	sol.print(N)
	sol.n += 5
	sol.nprint(N)
	return sol.answer
}

func main() {
	var t, N int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		fmt.Scan(&N)
		ob := Solution{}
		ans := ob.pattern(N)
		for i := 0; i < len(ans); i++ {
			fmt.Printf("%d ", ans[i])
		}
		fmt.Println()
	}
}
