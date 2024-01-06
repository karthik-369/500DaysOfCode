package main

import (
	"fmt"
)

func sumOfPowers(a, b int64) int64 {
	var answer int64

	for i := a; i <= b; i++ {
		answer += solve(i)
	}

	return answer
}

func solve(n int64) int64 {
	var answer int64

	for n%2 == 0 {
		answer++
		n /= 2
	}

	for i := int64(3); i*i <= n; i += 2 {
		for n%i == 0 {
			answer++
			n /= i
		}
	}

	if n > 2 {
		answer++
	}

	return answer
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var a, b int64
		fmt.Scan(&a, &b)

		res := sumOfPowers(a, b)
		fmt.Println(res)

		t--
	}
}
