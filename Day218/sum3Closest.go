package main

import (
	"fmt"
	"slices"
	"math"
)

func threeSumClosest(arr []int, target int) int {
	slices.Sort(arr)
	min := math.MaxInt
	answer := 0
	
	for i:=0; i<len(arr)-2; i++ {
		j := i+1
		k := len(arr) - 1
		for j < k {
			sum := arr[i] + arr[j] + arr[k]
			
			if min > int(math.Abs(float64(target - sum))) {
				min = int(math.Abs(float64(target - sum)))
				answer = sum
			}
			if sum < target {
				j++;
			} else {
				k--
			}
		}
	}
	return answer
}

func main() {
	arr := []int{-1,2,1,-4}
	target := 1
	fmt.Println(threeSumClosest(arr, target))
}

