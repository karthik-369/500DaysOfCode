package main

import (
	"fmt"
	"sort"
	
)

func maxLengthOfChain(pairs [][]int) int {
	l := len(pairs)
	if l == 1 {
		return 1
	}
	dp := make([]int, l)
	m := 1
	for i:=0; i<l; i++ {
		dp[i] = 1
	}
	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i][0] < pairs[j][0]
	})
	for i:=1; i<l; i++ {
		for j:=0; j<i; j++ {
			if pairs[i][0] > pairs[j][1] && dp[i]<dp[j]+1 {
				dp[i] = dp[j] + 1
			}
		}
		m = max(m, dp[i])
	}
	return m
}

func main() {
	arr := [][]int{{1,2},{7,8},{4,5}}
	fmt.Println(maxLengthOfChain(arr))
}