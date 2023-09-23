package main 

import (
	"fmt"
)

func equilibriumPoint(arr []int, n int) int {
	ts, p := 0, 0 
	for _,v := range arr {
		ts += v
	}
	for i, v := range arr{
		if p == ts - p - v {
			return i+1
		} else {
			p += v
		}
	}
	return -1
}

func main() {
	n := 5
	arr := []int{1,3,5,2,2}
	fmt.Println(equilibriumPoint(arr, n))
}