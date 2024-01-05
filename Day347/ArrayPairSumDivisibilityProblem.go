package main

import (
	"fmt"
)

func canPair(nums []int, k int) bool {
	if len(nums)%2 == 1 {
		return false
	}

	set := make(map[int]struct{})
	for i := 0; i < len(nums); i++ {
		temp := nums[i] % k
		if _, found := set[(k-temp)%k]; found {
			delete(set, (k-temp)%k)
		} else {
			set[temp] = struct{}{}
		}
	}

	return len(set) == 0
}

func main() {
	var T int
	fmt.Scan(&T)

	for t := 0; t < T; t++ {
		var n, k int
		fmt.Scan(&n, &k)

		nums := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Scan(&nums[i])
		}

		result := canPair(nums, k)
		if result {
			fmt.Println("True")
		} else {
			fmt.Println("False")
		}
	}
}
