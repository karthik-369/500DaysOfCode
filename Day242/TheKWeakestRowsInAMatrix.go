package main

import (
	"fmt"
	"sort"
)

type save struct {
	rank int
	index int
}

func KWeakestRows(mat [][]int, k int ) []int {
	answer := make([]int, k)
	n := len(mat)
	arr := make([]save, n)
	for i, r := range mat {
		rank := 0 
		for _,v := range r {
			rank += v
		}
		arr[i] = save{rank, i}
	} 	
	sort.Slice(arr, func(i int, j int) bool {
		if arr[i].rank == arr[j].rank {
			return arr[i].index < arr[j].index
		}
		return arr[i].rank<arr[j].rank
	})
	for i:=0; i<k; i++ {
		answer[i] = arr[i].index
	}
 	return answer
}

func main() {
	arr := [][]int{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}
	k:=3
	arr2 := [][]int{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}}
	arr3 := [][]int{{1,0},{1,0},{1,0},{1,1}}
	fmt.Println(KWeakestRows(arr, k))
	fmt.Println(KWeakestRows(arr, 4))
	fmt.Println(KWeakestRows(arr2, k))
	fmt.Println(KWeakestRows(arr3, 4))
}

