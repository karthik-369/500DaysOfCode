package main

import (
	"fmt"
)

func checkKthBit(n, k int) bool {
	return (n>>k)&1 == 1
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var n, k int
		fmt.Scan(&n, &k)

		if checkKthBit(n, k) {
			fmt.Println("Yes")
		} else {
			fmt.Println("No")
		}

		t--
	}
}
