package main

import (
	"fmt"
	"math"
)

func findMaxSum(arr []int, n int) int {
	curr , prev := 0, 0
	for _,v := range arr {
		temp := int(math.Max(float64(prev + v), float64(curr)))
		prev = curr
		curr = temp
	}
	return curr
}

func main() {
	arr := []int{6,5,5,7,4}

	fmt.Print(findMaxSum(arr, 5))
}

