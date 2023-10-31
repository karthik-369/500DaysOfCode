package main

import (
	"fmt"
)

func pushZerosToEnd(arr []int, n int) {
	zero := 0
	for i:=0; i<n; i++ {
		if arr[i] != 0 {
			temp := arr[zero]
			arr[zero] = arr[i]
			arr[i] = temp
			zero++
		}

	}
}

func main() {
	n1 := 5
	n2 := 4
	arr1 := []int{3,5, 0, 0, 4}
	arr2 := []int{0, 0, 0, 4}
	
	pushZerosToEnd(arr1, n1)
	pushZerosToEnd(arr2, n2)
	fmt.Println(arr1)
	fmt.Println(arr2)
}