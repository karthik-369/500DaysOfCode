package main

import (
	"fmt"
)

func isRepresentingBST(arr []int, n int) int {
	for i:=1; i<n; i++ {
		if arr[i-1] > arr[i] {
			return 0
		}
	}
	return 1
}

func main() {
	arr := []int{1,2,3,5,6}
	fmt.Println(isRepresentingBST(arr, 5))
}