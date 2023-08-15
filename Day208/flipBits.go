package main

import (
	"fmt"
)

func flipBits(arr []int) int {
	mc := 0
	cz := 0
	oc := 0
	for i:=0; i<len(arr); i++ {
		if arr[i] == 0 {
			cz++
		} else {
			oc ++
			cz--
		}
		mc = max(mc, cz)
		if cz<0 {
			cz = 0
		}
	}
	return mc + oc
}

func main() {
	arr := []int{1, 0, 0, 1, 1}
	fmt.Println(flipBits(arr))
}

