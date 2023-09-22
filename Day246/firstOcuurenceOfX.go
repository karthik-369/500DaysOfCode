package main

import (
	"fmt"
)

func find(arr []int, n int, x int) []int {
	low, high := 0, n-1
	answer := []int{}

	for low <= high {
		mid := high - ((high - low)>>1)

		if arr[mid] == x {
			for mid >= 1 && arr[mid-1] == x {
				mid--
			}
			answer = append(answer, mid)

			for mid < n-1 && arr[mid+1] == x {
				mid++
			}
			answer = append(answer, mid)
			return answer
		} else if x > arr[mid] {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}

	answer = append(answer, -1)
	answer = append(answer, -1)
	return answer
}

func main() {
	n := 9
	arr := []int{1, 3, 5, 5, 5, 5, 67, 123, 125}
	x := 5
	fmt.Println(find(arr, n, x))
}
