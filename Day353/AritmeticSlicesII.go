package main

import (
	"fmt"
)

func numberOfArithmeticSlices(arr []int) int {
	answer := 0
	n := len(arr)
	dp := make([][]int, n)
	for i,_ := range dp {
		dp[i] = make([]int, n)
	}
	m := make(map[int64][]int)
	for i:=0; i<n; i++ {
		var temp int64 =  int64(arr[i])
		if _, flag := m[temp]; !flag {
			m[temp] = make([]int, 0)
		}
		m[temp] = append(m[temp], i)
	}
	for i:=1; i<n; i++ {
		for j:=i+1; j<n; j++ {
			var temp int64 = int64(2 * arr[i]) - int64(arr[j])
			if _,flag := m[temp]; flag {
				for _,v := range m[temp] {
					if v < i {
						dp[i][j] += dp[v][i] + 1
					} else {
						break
					}
				}
			}
			answer += dp[i][j]
		}
	}
	return answer
}

func main() {
	arr1 := []int{2,4,6,8, 10}
	arr2 := []int{7,7,7,7,7}
	fmt.Println(numberOfArithmeticSlices(arr1))
	fmt.Println(numberOfArithmeticSlices(arr2))
}