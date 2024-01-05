package main

import "fmt"

func maxSumWithK(a []int64, n, k int64) int64 {
	var answer, temp1, temp2, i, t int64

	for i = 0; i < k; i++ {
		temp1 += a[i]
	}

	answer = temp1

	for i < n {
		temp1 += a[i]
		temp2 += a[i-k]
		t = min(t, temp2)
		answer = max(answer, temp1-t)
		i++
	}

	return answer
}

func max(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}

func min(a, b int64) int64 {
	if a < b {
		return a
	}
	return b
}

func main() {
	var T int64
	fmt.Scan(&T)

	for t := int64(0); t < T; t++ {
		var n, k int64
		fmt.Scan(&n)

		a := make([]int64, n)
		for i := int64(0); i < n; i++ {
			fmt.Scan(&a[i])
		}

		fmt.Scan(&k)

		result := maxSumWithK(a, n, k)
		fmt.Println(result)
	}
}
