package main

import (
	"fmt"	
)

func reverse(arr []int, n int ) []int {
	i := 0
	j := n - 1
	for i <= j {
		arr[i], arr[j] = arr[j], arr[i]
		i++
		j--
	}
	// fmt.Println(arr)
	return arr
}

func leader(arr []int, n int ) []int {
	list := make([]int, 0)
	max := arr[n - 1]
	list = append(list, max)
	for i:=n-2; i>=0; i-- {
		if max <= arr[i] {
			max = arr[i]
			list = append(list, max)
		}
	}
	reverse(list, len(list))
	return list
}

func main() {
	arr := []int{6,17,4,3,5,2};
	n := 6
	fmt.Println(leader(arr, n))
}