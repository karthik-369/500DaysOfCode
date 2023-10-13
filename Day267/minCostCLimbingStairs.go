package main

import (
	"fmt"
	"math"
)

func minCostClimbingStairs(arr []int) int {
	arr = append(arr, 0)
	for i:= len(arr) - 3; i >= 0; i-- {
		arr[i] += int(math.Min(float64(arr[i+1]), float64(arr[i+2])))
	}
	return int(math.Min(float64(arr[0]), float64(arr[1])))
}

func main() {
	arr1 := []int{10, 15, 20}
	arr2 := []int{1,100,1,1,1,100,1,1,100,1}
	fmt.Println(minCostClimbingStairs(arr1))
	fmt.Println(minCostClimbingStairs(arr2))
}