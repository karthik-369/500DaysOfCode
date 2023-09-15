package main

import (
	"fmt"
)

func isSub(arr []int, n int , pos int, sum int, kn [][]int) bool {
	if sum == 0 {
		return true
	} else if pos >= n || sum < 0 {
		return false
	}
	if kn[pos][sum] != -1 {
		if kn[pos][sum] == 1 {
			return true
		}
		return false
	}
	dec := (isSub(arr, n, pos+1, sum - arr[pos], kn) || isSub(arr, n, pos+1, sum, kn))
	if dec {
		kn[pos][sum] = 1
	} else {
		kn[pos][sum] = 0
	}
	// fmt.Println(kn)
	return dec
}

func equalPartition(n int, arr []int) int {
	sum := 0
	for i:=0; i<n; i++ {
		sum += arr[i]
	}
	if ((sum & 1) == 1) {
		return 0
	}
	kn := make([][]int, n+1)
	for i:=0; i<=n; i++ {
		kn[i] = make([]int, sum/2+1)
		for j:=0; j<=sum/2; j++ {
			kn[i][j] = -1
		}
	}
	if isSub(arr, n, 0, sum/2, kn) {
		return 1
	}
	return 0
}

func main() {
	arr := []int{1, 5, 11, 5}
	n := 4
	fmt.Println(equalPartition(n, arr))
}