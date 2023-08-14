package main

import (
	"fmt"
)

func singleNumber(arr []int) []int {
	answer := make([] int, 2);
	freq := make(map[int]int)
	for i:=0; i<len(arr); i++ {
		freq[arr[i]]++
	}
	point := 0
	for key, value := range(freq) {
		if value == 1 {
			answer[point] = key
			point++ 
		}
	}
	if answer[0]>answer[1] {
		answer[0] = answer[0] ^ answer[1]
		answer[1] = answer[1] ^ answer[0]
		answer[0] = answer[0] ^ answer[1]
	}
	return answer
}

func main() {
	arr := []int{18, 24, 24, 21, 10, 29, 8, 10 ,29 ,18}

	fmt.Println(singleNumber(arr))
}