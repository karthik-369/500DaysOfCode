package main

import "fmt"

func minOperation(n int) int {
	op := 0
	for n > 0 {
		if n%2 == 0 {
			n /= 2
		} else {
			n--
		}
		op++
	}
	return op
}

func main() {
	var t, n int
	fmt.Scan(&t)

	for t > 0 {
		fmt.Scan(&n)
		result := minOperation(n)
		fmt.Println(result)
		t--
	}
}
