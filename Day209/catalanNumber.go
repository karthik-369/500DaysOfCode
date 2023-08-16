package main

import (
	"fmt"
	
)

func catalan(n int) int {
	if n <= 1 {
		return 1
	}
	mod := 1000000007;
	dp := make([] int, n+1)
	dp[0] = 1
	dp[1] = 1
	for i:=2; i<=n; i++ {
		dp[i] = 0
		for j:=0; j<i; j++ {
			dp[i] = (dp[i] + dp[j]*dp[i - j - 1]%mod)%mod
		}
	}
	fmt.Println(dp)
	return dp[n]
}

func main() {
	var n int
	fmt.Println("Enter the number : ")
	fmt.Scanln(&n)
	fmt.Println(catalan(n))
}