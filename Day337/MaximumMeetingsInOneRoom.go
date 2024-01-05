package main

import "fmt"

func maxScore(s string) int {
	answer, zero, one := 0, 0, 0

	for i := 0; i < len(s); i++ {
		if s[i] == '1' {
			one++
		}
	}

	for i := 0; i < len(s)-1; i++ {
		if s[i] == '0' {
			zero++
		} else {
			one--
		}
		answer = max(answer, one+zero)
	}

	return answer
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	s := "011101"
	result := maxScore(s)
	fmt.Println(result)
}
