package main

import (
	"fmt"
)

func minimumNumberOfDeletions(S string) int {
	lenS := len(S)
	reversedS := reverse(S)
	arr := make([][]int, lenS+1)
	for i := range arr {
		arr[i] = make([]int, lenS+1)
	}

	for i := 0; i <= lenS; i++ {
		for j := 0; j <= lenS; j++ {
			if i == 0 || j == 0 {
				arr[i][j] = 0
			} else if S[i-1] == reversedS[j-1] {
				arr[i][j] = 1 + arr[i-1][j-1]
			} else {
				arr[i][j] = max(arr[i][j-1], arr[i-1][j])
			}
		}
	}
	return lenS - arr[lenS][lenS]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func reverse(str string) string {
	runes := []rune(str)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var S string
		fmt.Scan(&S)

		result := minimumNumberOfDeletions(S)
		fmt.Println(result)
		t--
	}
}
