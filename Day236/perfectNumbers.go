package main

import (
	"fmt"
	"math"
)

func purfect(n int) bool {
	var sum float64 = 1
	var temp float64 = float64(n)
	var i float64
	for i=2; i<math.Sqrt(temp); i++ {
		var div int = int(i)
		if n%div == 0 {
			sum += i
			sum += float64 (n/div)
		}
	}
	if sum == temp {
		return true
	}
	return false
}

func main() {
	n := 10
	fmt.Println(purfect(n))
}