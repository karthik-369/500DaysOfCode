package main

import (
	"fmt"
)

func nimGame(arr []int, n int) int {
	temp := 0
	for _,v := range arr {
		temp ^= v
	}
	if temp == 0 {
		return 1
	}
	return n%2+1
}

func main() {
	arr1 := []int{3,2,3}
	fmt.Println(nimGame(arr1, 3))
}