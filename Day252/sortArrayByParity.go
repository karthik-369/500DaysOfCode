package main 

import (
	"fmt"
)

func sortArrayByParity(nums []int) []int {
	point := 0
	for i:=0; i<len(nums); i++ {
		if nums[i]&1 != 1 {
			nums[i], nums[point] = nums[point], nums[i]
			point++
		}
	}
	return nums
}

func main() {
	nums := []int{3,1,2,4}
	fmt.Println(sortArrayByParity(nums))
}