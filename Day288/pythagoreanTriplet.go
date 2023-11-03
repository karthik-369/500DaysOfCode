package main

import (
	"fmt"
)

func checkTriplet(arr []int, n int) bool {
	set := make(map[int]bool)
	for i := 0; i < n; i++ {
		set[arr[i]*arr[i]] = true
	}
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if set[arr[i]*arr[i]+arr[j]*arr[j]] {
				return true
			}
		}
	}
	return false
}

func main() {
	var tc int
	fmt.Scan(&tc)

	for tc > 0 {
		var n int
		fmt.Scan(&n)
		arr := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Scan(&arr[i])
			arr[i] *= arr[i]
		}

		ans := checkTriplet(arr, n)
		if ans {
			fmt.Println("Yes")
		} else {
			fmt.Println("No")
		}

		tc--
	}
}
