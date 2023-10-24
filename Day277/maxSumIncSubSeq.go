package main

import (
	"fmt"
	"math"
)

func maxSumInc (n int, num []int) int {
	a := make([]int, n)
	answer := 0 
	for  i,v := range num {
		a[i] = v
	}
	for i:=0; i<n; i++ {
		for j:=0; j<i; j++ {
			if num[i] > num[j] {
				a[i] = int(math.Max(float64(a[i]), float64(a[j] + num[i])))
			}
 		}
		answer = int(math.Max(float64(answer), float64(a[i])))
	}
	return answer
}

func main() {
	n1 := 5
	n2 := 4
	num1 := []int{1, 101, 2, 3, 100}
	num2 := []int{4, 1, 2, 3}
	fmt.Println(maxSumInc(n1, num1))
	fmt.Println(maxSumInc(n2, num2))
}