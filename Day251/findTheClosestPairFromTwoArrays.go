package main

import (
	"fmt"
	"math"
)

func printClosest(arr []int, brr []int,x int ) []int {
	answer := make([]int ,2)
	i, j := 0, len(brr) -1
	min := math.MaxInt
	for i < len(arr) && j >= 0 {
		temp := arr[i] + brr[j]
		diff := math.Abs(float64(temp - x))
		if int(diff) < min {
			min = int(diff)
			answer[0] = arr[i]
			answer[1] = brr[j]
		}
		if temp < x {
			i++
		} else {
			j--
		}
	}
	return answer
}


func main() {
	arr := []int{1, 4, 5, 7}
	brr := []int{10, 20, 30, 40}
    x := 32
	answer := printClosest(arr, brr, x)
	fmt.Println(math.Abs(float64(answer[0]+answer[1]-x)))
}