package main

import (
	"fmt"
	"math"
)

func isPrime(n int) bool {
	for i:=2; i<= int(math.Sqrt(float64(n))); i++ {
		if n%i == 0 {
			return false
		}
	}
	return true
}

func minNumber(arr []int) int {
	sum := 0
	for _,v := range arr {
		sum += v
	}
	if sum == 0 {
		return 0
	}
	if sum == 1 {
		return 1
	}
	temp := sum
	for !isPrime(sum) {
		sum++
	}
	return sum - temp
}

func main() {
	arr1 := []int{2, 4, 6, 8, 12}
	arr2 := []int{1, 5, 7}
	arr3 := []int{1, 0, 0}
	fmt.Println(minNumber(arr1))
	fmt.Println(minNumber(arr2))
	fmt.Println(minNumber(arr3))
}