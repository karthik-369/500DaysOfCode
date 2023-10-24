package main

import (
	"fmt"
)

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func isPal(str string, i, j int) bool {
	for i < j {
		if str[i] != str[j] {
			return false
		}
		i++
		j--
	}
	return true
}

func palindromicPartition(str string) int {
	n := len(str)
	arr := make([]int, n)
	for i := range arr {
		arr[i] = -1
	}

	var pal func(ind, n int, str string) int
	pal = func(ind, n int, str string) int {
		if ind == n {
			return 0
		}
		if arr[ind] != -1 {
			return arr[ind]
		}
		minPartitions := 1 << 31 - 1
		for i := ind; i < n; i++ {
			if isPal(str, ind, i) {
				minPartitions = min(minPartitions, 1+pal(i+1, n, str))
			}
		}
		arr[ind] = minPartitions
		return minPartitions
	}

	return pal(0, n, str) - 1
}

func main() {
	var t int
	fmt.Scan(&t)
	for t > 0 {
		var str string
		fmt.Scan(&str)
		result := palindromicPartition(str)
		fmt.Println(result)
		t--
	}
}
