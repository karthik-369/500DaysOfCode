package main

import (
	"fmt"
)

func lSearch (arr []int, target int, low int, high int) int {
	for low <= high {
		mid := high- ((high - low) >> 1)
		if arr[mid] == target {
			return mid
		}
		if arr[mid] < target {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}

func rSearch (arr []int, target int, low int, high int) int {
	for low <= high {
		mid := high - ((high - low ))
		if arr[mid] > target {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}

func findInMountainArray (arr []int, target int) int {
	low, high := 0, len(arr)-1
	for low < high {
		mid := low + (high - low) /2
		if arr[mid] < arr[mid+1] {
			low = mid +1
		} else {
			high = mid -1
		}
	}
	test := lSearch(arr, target, 0, low);
	if test == -1 {
		return rSearch(arr, target, low + 1, len(arr) -1)
	}
	return test;
}


func main() {
	arr1 := []int{1,2,3,4,5,3,1}
	target1 := 3
	arr2 := []int{0,1,2,4,2,1}
	target2 := 3
	arr3 := []int{3}
	target3 := 3
	arr4 := []int{1,2,3,5,3};
	target4 := 0
	fmt.Println(findInMountainArray(arr1, target1))
	fmt.Println(findInMountainArray(arr2, target2))
	fmt.Println(findInMountainArray(arr3, target3))
	fmt.Println(findInMountainArray(arr4, target4))

}