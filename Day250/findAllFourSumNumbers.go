package main

import (
	"fmt"
	"sort"
)

func fourSum(nums []int, target int) [][]int {
	var result [][]int
	sort.Ints(nums)

	for i := 0; i < len(nums)-3; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		for j := i + 1; j < len(nums)-2; j++ {
			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}

			low, high := j+1, len(nums)-1

			for low < high {
				sum := nums[i] + nums[j] + nums[low] + nums[high]

				if sum == target {
					result = append(result, []int{nums[i], nums[j], nums[low], nums[high]})
					for low < high && nums[low] == nums[low+1] {
						low++
					}
					for low < high && nums[high] == nums[high-1] {
						high--
					}
					low++
					high--
				} else if sum < target {
					low++
				} else {
					high--
				}
			}
		}
	}

	return result
}

func main() {
	arr1 := []int{0, 0, 2, 1, 1}
	arr2 := []int{10, 2, 3, 4, 5, 7, 8}
	k1 := 3
	k2 := 23

	fmt.Println(fourSum(arr1, k1))
	fmt.Println(fourSum(arr2, k2))
}
