package main

import (
	"fmt"
	"sort"
)

func findUniqueSum(nums []int) int {
	l := len(nums)

	// Sorting the array
	sort.Ints(nums)

	// Reversing the array
	for i := 0; i < l/2; i++ {
		temp := nums[i]
		nums[i] = nums[l-i-1]
		nums[l-i-1] = temp
	}

	answer := 0
	for i := 0; i < l-1; i++ {
		if nums[i] == nums[l-1] {
			return answer
		}
		if nums[i] != nums[i+1] {
			answer += i + 1
		}
	}
	return answer
}

func main() {
	// Example usage
	nums := []int{3, 2, 1, 3, 2, 4, 5}
	result := findUniqueSum(nums)
	fmt.Println(result)
}
