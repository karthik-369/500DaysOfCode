package  main

import (
	"fmt"
)

func search(nums []int, target int) bool {
    low:=0
    high:=len(nums)-1
    for low<= high{
        mid:= high - ((high-low)>>1)
        if(nums[mid]==target){
            return true
        }
        if(nums[mid]==nums[low] && nums[high]==nums[mid]){
            low++
            high--
        }else if(nums[low]<=nums[mid]){
            if(target>=nums[low] && target<nums[mid]){
                high = mid -1

            }else{
                low = mid+1
            }
        }else{
            if(target<=nums[high] && target>nums[mid]){
                low = mid +1
            }else{
                high = mid-1
            }
        }
        
    }
    return false
}
func main() {

	var arr = []int{1,0,1,1,1,1,1}
	fmt.Println(len(arr))
	fmt.Println(search(arr, 0))
}