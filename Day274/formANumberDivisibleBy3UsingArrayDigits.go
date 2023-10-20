package main

import (
	"fmt"
)

func isPossible(n int, arr []int) bool {
	var temp int64 = 0;
	for _,v := range arr {
		temp += int64(v)
	}
	if temp %3 == 0 {
		return true
	}
	return false
}

func main() {
	n := 3
	arr := []int{40, 50, 90}
	fmt.Println(isPossible(n , arr))
}