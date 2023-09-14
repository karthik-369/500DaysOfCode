
package main

import (
	"fmt"
)

func perfectSum(n int, arr []int, sum int) int {
	dp:= make([]int, sum+1)
	dp[0] = 1
	for i:=0; i<n; i++ {
		for j:=sum; j>=arr[i]; j-- {
			dp[j] = (dp[j] + dp[j-arr[i]])%1000000007;
		}
	}
	return dp[sum]
}

func main() {
	arr := []int{9 ,7 ,0 ,3 ,9 ,8 ,6 ,5 ,7 ,6}
	n := 10
	sum := 31
	fmt.Println(perfectSum(n, arr, sum))
}
