package main

import (
	"fmt"
)
func searchRange(nums []int, target int) []int {
    low, high := 0, len(nums)-1
    answer := []int{-1,-1}
    for low <= high {
        mid := high - ((high-low)>>1)
        
        if (nums[mid] == target) {
            temp := mid
            for mid >=1 && nums[mid-1] == target {
                mid--
            }
            answer[0] = mid
            mid = temp
            for mid < len(nums)-1 && nums[mid+1] == target {
                mid++
            }
            answer[1] = mid
            return answer
        } else if target > nums[mid] {
            low = mid + 1
        } else {
            high = mid -1
        }
        
    }
    return answer
}
func main() {
	
	arr := []int{1, 3, 5, 5, 5, 5, 67, 123, 125}
	arr1 := []int{1}
	
	x1 :=1
	x := 5
	fmt.Println(searchRange(arr, x))
	fmt.Println(searchRange(arr1, x1))
}