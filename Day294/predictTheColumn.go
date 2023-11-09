package main

import (
	"fmt"
	"sort"
)

func columnWithMaxZeros(arr [][]int, N int) int {
	temp := make([][2]int, N)

	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			if arr[i][j] == 0 {
				temp[j][0] = j
				temp[j][1]++
			}
		}
	}

	sort.Slice(temp, func(i, j int) bool {
		if temp[i][1] != temp[j][1] {
			return temp[i][1] > temp[j][1]
		}
		return temp[i][0] < temp[j][0]
	})

	if temp[0][1] == 0 {
		return -1
	}

	return temp[0][0]
}

func main() {
	var t, N int
	fmt.Scan(&t)

	for t > 0 {
		fmt.Scan(&N)
		arr := make([][]int, N)
		for i := 0; i < N; i++ {
			arr[i] = make([]int, N)
			for j := 0; j < N; j++ {
				fmt.Scan(&arr[i][j])
			}
		}

		result := columnWithMaxZeros(arr, N)
		fmt.Println(result)

		t--
	}
}
