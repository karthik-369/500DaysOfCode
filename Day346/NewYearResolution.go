package main

import (
	"fmt"
)

func solve(i int, temp *int, n int, coins []int, dp [][]int) bool {
	if *temp != 0 && (*temp %20 == 0 || *temp % 24 == 0 || *temp == 2024) {
		return true
	}
	if i>=n || *temp  > 2024 {
		return false
	}
	if dp[i][*temp] != -1 {
		if dp[i][*temp] == 1 {
			return true
		}
		return false
	}
	tt := *temp + coins[i]
	t := solve(i+1, &tt, n, coins, dp) || solve(i+1, temp, n, coins, dp)
	if t {
		dp[i][*temp] = 1
	} else {
		dp[i][*temp] = 0
	}
	return t
}

func isPossible(n int, coins []int) bool {
	dp := make([][]int, 367)
	for i,_ := range dp {
		dp[i] = make([]int, 2025)
		for j,_ := range dp[i] {
			dp[i][j] = -1
		}
	}
	temp := 0
	return solve(0, &temp, n, coins, dp)
}

func main() {
	arr1 := []int{5, 8, 9, 10, 14, 2, 3, 5} 
	n1 := 8
	arr2 := []int{1, 2, 3, 4, 5}
	n2 := 5
	fmt.Println(isPossible(n1, arr1))
	fmt.Println(isPossible(n2, arr2))
}