package main

import (
	"fmt"
)

func subarraySum(arr []int, s int) []int {
	answer := []int{}
	start := 0
	sum := 0

	for i := 0; i < len(arr); i++ {
		sum += arr[i]

		for start < i && sum > s {
			sum -= arr[start]
			start++
		}

		if sum == s {
			answer = append(answer, start+1)
			answer = append(answer, i+1)
			break
		}
	}

	if len(answer) == 0 {
		answer = append(answer, -1)
	}

	return answer
}

func main() {
	arr := []int{1, 2, 3, 4, 5}
	s := 9
	result := subarraySum(arr, s)
	fmt.Println(result)
}
