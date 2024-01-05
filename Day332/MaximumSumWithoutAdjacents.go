package main

import (
	"fmt"
)

func findMaxSum(arr []int, n int) int {
	temp := arr[0]
	temp2 := 0
	for i := 1; i < n; i++ {
		t1 := temp
		t2 := temp2 + arr[i]
		max := t1
		if t2 > t1 {
			max = t2
		}
		temp2 = temp
		temp = max
	}
	return temp
}

func main() {
	var tc int
	fmt.Scan(&tc)

	for t := 0; t < tc; t++ {
		var n int
		fmt.Scan(&n)

		arr := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Scan(&arr[i])
		}

		ans := findMaxSum(arr, n)
		fmt.Println(ans)
	}
}
