package main

import (
	"fmt"
)

func gameOfXOR(arr []int,) int {
	if len(arr)%2 ==0 {
		return 0
	}
	answer :=0
	for i:=0; i<len(arr); i+=2 {
		answer ^= arr[i]
	}
	return answer
}

func main() {
	arr1 := []int{1,2,3}
	arr2 := []int{1,2}
	fmt.Println(gameOfXOR(arr1))
	fmt.Println(gameOfXOR(arr2))
}