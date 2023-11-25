package main

import (
	"fmt"
)

func shuffleArray(arr []int, n int) {
	l := n
	n /= 2

	for i := n; i < l; i++ {
		arr[i] = (arr[i] << 10) | arr[i-n]
	}

	ind := 0
	for i := n; i < l; i++ {
		arr[ind] = arr[i] & 1023
		arr[ind+1] = arr[i] >> 10
		ind += 2
	}
}

func main() {
	var testcases, n int
	fmt.Scan(&testcases)

	for t := 0; t < testcases; t++ {
		fmt.Scan(&n)
		arr := make([]int, n)

		for i := 0; i < n; i++ {
			fmt.Scan(&arr[i])
		}

		shuffleArray(arr, n)

		for i := 0; i < n; i++ {
			fmt.Printf("%d ", arr[i])
		}
		fmt.Println()
	}
}
