package main

import (
	"fmt"
	"math"
	"sort"
)

func minimumOperation(nums []int) int {
	answer := math.MaxInt
	sort.Ints(nums)
	j, temp := 1, 0
	tempArr := make([]int, len(nums))
	for i:=0; i<len(nums); i++ {
		for j<len(nums) && nums[j]<=nums[i]+len(nums)-1 {
			if nums[j] == nums[j-1] {
				temp++
			}
			tempArr[j] = temp;
			j++;
		}
		answer = int(math.Min(float64(answer), float64(i + (len(nums)-j) + temp - tempArr[i])))
	}
	return answer
}

func main() {
	arr1 := []int{4,2,5,3}
	arr2 := []int{1,2,3,4,5,6}
	arr3 := []int{1,10,100,1000}
	fmt.Println(minimumOperation(arr1))
	fmt.Println(minimumOperation(arr2))
	fmt.Println(minimumOperation(arr3))
}

