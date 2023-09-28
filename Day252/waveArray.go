package main 

import (
	"fmt"
)

func waveArray(n int, arr []int) {
	for i:=0 ;i<n-1; i+=2 {
		arr[i], arr[i+1] = arr[i+1], arr[i]
	}
}

func main() {
	arr1 := []int{1,2,3,4,5}
	n1 := 5
	arr2 := []int{2,4,7,8,9,10}
	n2 := 6
	waveArray(n1, arr1)
	waveArray(n2, arr2)
	fmt.Println(arr1)
	fmt.Println(arr2)
}