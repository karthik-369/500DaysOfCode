package main

import (
	"fmt"
)

func nthRowOfPascalTriangle(n int) []int {
	var answer []int
	mod := 1000000007

	for i := 0; i < n; i++ {
		var temp []int
		for j := 0; j < i+1; j++ {
			if j == i || j == 0 {
				temp = append(temp, 1)
			} else {
				num := (answer[j] + answer[j-1]) % mod
				temp = append(temp, num)
			}
		}
		answer = temp
	}

	return answer
}

func main() {
	var t, n int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		fmt.Scan(&n)
		ans := nthRowOfPascalTriangle(n)
		printAns(ans)
	}
}

func printAns(ans []int) {
	for _, x := range ans {
		fmt.Printf("%d ", x)
	}
	fmt.Println()
}
