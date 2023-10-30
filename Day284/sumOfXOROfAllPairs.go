package main

import (
	"fmt"
)

func sumXOR(arr []int, n int) int64 {
	var answer int64
	for i := 0; i < 32; i++ {
		var temp1, temp2 int64
		for j := 0; j < n; j++ {
			if (arr[j] & 1) == 0 {
				temp1++
			} else {
				temp2++
			}
			arr[j] >>= 1
		}
		answer += temp1 * temp2 * (1 << i)
	}
	return answer
}

func main() {
	var testcases int
	fmt.Scan(&testcases)

	for testcases > 0 {
		var sizeOfArray int
		fmt.Scan(&sizeOfArray)

		arr := make([]int, sizeOfArray)
		for i := 0; i < sizeOfArray; i++ {
			fmt.Scan(&arr[i])
		}

		res := sumXOR(arr, sizeOfArray)
		fmt.Println(res)
		testcases--
	}
}
