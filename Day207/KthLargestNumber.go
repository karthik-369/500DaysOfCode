package main

import (
	"fmt"
	
	"math/rand"
	"time"
)

//TLE
// func kthlargestNumber(arr []int, k int) int {
// 	mi := 0
// 	answer := arr[0]
	
// 	n := len(arr)
// 	for k != 0 {
// 		max := -10001
// 		for i:=0; i<n; i++ {
// 			if max <= arr[i] {
// 				max = arr[i]
// 				mi = i
// 			}
// 		}
// 		answer = arr[mi]
// 		arr[mi] = math.MinInt
// 		k--
// 	}
// 	return answer
// }

func kthlargestNumber(arr []int , k int) int {
	k = len(arr) - k
	rand.Seed(time.Now().UnixNano())
	for i:=len(arr) - 1; i>=0; i-- {
		j := rand.Intn(i+1)
		swap(arr, i, j)
	}
	return quickSelect(arr, 0, len(arr)-1, k)
}

func quickSelect(arr []int, start int, end int, k int ) int {
	pivot := arr[end]
	point := start

	for i:=start; i<end; i++ {
		if arr[i] <= pivot {
			swap(arr, i, point)
			point++
		}
	}
	swap(arr, point, end)
	if point>k {
		return quickSelect(arr, start, point-1, k)
	} else if point<k {
		return quickSelect(arr, point+1, end, k)
	}
	return arr[point]
}

func swap(arr []int, i int, j int){
	arr[i], arr[j] = arr[j], arr[i]
}

func main() {
	arr := []int{3,2,3,1,2,4,5,5,6}
	k := 4
	fmt.Println(kthlargestNumber(arr, k))
}