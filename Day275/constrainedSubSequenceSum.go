package main

import (
	"fmt"
	"math"
)
func constrainedSubsetSum(nums []int, k int) int {
    queue := make([]int, 0)
    for i:= range nums {
        if len(queue) != 0 {
            nums[i] += nums[queue[0]]
        }
        for len(queue) != 0 && (i-queue[0] >= k || nums[i] >= nums[queue[len(queue)-1]]) {
            if nums[i] >= nums[queue[len(queue)-1]] {
                queue = queue[:len(queue)-1]
            } else {
                queue = queue[1:]
            }
        }
        if nums[i] > 0 {
            queue = append(queue, i)
        }
    }
    max := nums[0]
    for i:=1; i<len(nums); i++ {
        max = int(math.Max(float64(max), float64(nums[i]) ))
    }
    return max
}
func main() {
	k2 := 2
	k1 := 2
	k3 := 3
	nums1 := []int{10,2, -10, 5, 20}
	nums2 := []int{-1,-2, -2}
	nums3 := []int{10,-2, -10, -5,20}
	fmt.Println(constrainedSubsetSum(nums1, k1));
	fmt.Println(constrainedSubsetSum(nums2, k2));
	fmt.Println(constrainedSubsetSum(nums3, k3));
}