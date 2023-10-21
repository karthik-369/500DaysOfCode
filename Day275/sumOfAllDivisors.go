package main

import (
	"math"
)

func sumOfDivisors(n int) int64 {
	var answer int64 = 0
	for i:=1; i<=int(math.Sqrt(float64(n))); i++ {
		var temp1 int64 = int64(i * (n/i-i+1))
		temp2 := int64((((n/i)*(n/i+1))/2) - ((i*(i+1))/2))
		answer += temp1 + temp2
	}
	return answer
}