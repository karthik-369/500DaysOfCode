package main

import (
	"fmt"
	// "math"
)

func fSum(n int) int {
	i := 2
	answer := 0
	for n > 1 {
		if n%i == 0 {
			answer += dSum(i)
			n /= i
		} else {
			for !isPrime(i) {
				i++
			}
		}
	}
	return answer
}

func isPrime(n int) bool {
	if n <= 1 {
		return false
	}
	for i := 2; i*i <= n; i++ {
		if n%i == 0 {
			return false
		}
	}
	return true
}

func dSum(n int) int {
	answer := 0
	for n > 0 {
		answer += n % 10
		n /= 10
	}
	return answer
}

func smithNum(n int) int {
	if isPrime(n) {
		return 0
	}
	if dSum(n) == fSum(n) {
		return 1
	}
	return 0
}

func main() {
	var t int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		var n int
		fmt.Scan(&n)

		ans := smithNum(n)
		fmt.Println(ans)
	}
}
