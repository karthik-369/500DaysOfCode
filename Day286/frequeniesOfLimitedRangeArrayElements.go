package main

import (
	"fmt"
)

func frequencyCount(arr []int, N, P int) {
	frequency := make(map[int]int)
	for i := 0; i < N; i++ {
		frequency[arr[i]]++
	}

	for i := 0; i < N; i++ {
		arr[i] = frequency[i+1]
	}
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var N int
		fmt.Scan(&N)

		arr := make([]int, N)
		for i := 0; i < N; i++ {
			fmt.Scan(&arr[i])
		}

		var P int
		fmt.Scan(&P)

		frequencyCount(arr, N, P)

		for i := 0; i < N; i++ {
			fmt.Print(arr[i], " ")
		}
		fmt.Println()
		t--
	}
}
