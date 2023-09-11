package main

import (
	"fmt"
)

func isLucky(n int) bool {
	if n%2 == 0 {
		return false
	}
	pos := 2;
	for pos <= n {
		if (n%pos == 0) {
			return false
		}
		n = n - (n/pos)
		pos ++
	}
	return true
}

func main() {
	n := 18
	fmt.Println(isLucky(n))
}