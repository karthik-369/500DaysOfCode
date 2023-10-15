package main

import (
	"fmt"
	"math"
)

func numWays(steps, arrLen int) int {
	mod := 1000000007;
	max := int(math.Min(float64(arrLen-1), float64(steps/2)))
	dp := make([][]int, steps+1)
	for i:= range dp {
		dp[i] = make([]int, max+1)
	}
	dp[0][0] = 1
	for i:=1; i<=steps; i++ {
		for j:=0; j<=max; j++ {
			dp[i][j] = dp[i-1][j]
			if j>0 {
				dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % mod
			}
			if j<max {
				dp[i][j] = (dp[i][j] + dp[i-1][j+1]) %mod
			}
		}
	}
	return dp[steps][0]
}

func main() {
	steps1, arrLen1 := 3, 2
	steps2, arrLen2 := 2, 4
	steps3, arrLen3 := 4, 2
	fmt.Println(numWays(steps1, arrLen1))
	fmt.Println(numWays(steps2, arrLen2))
	fmt.Println(numWays(steps3, arrLen3))
}
