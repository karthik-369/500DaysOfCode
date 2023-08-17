package main

import (
	"fmt"
)

func right(arr []int, n int) bool {
	i := (n-1)/2
	j := n/2
	for i >=0 && j < n {
		if arr[i] < arr[j] {
			return true
		} else if arr[i] > arr[j] {
			return false
		}
		i--
		j++
	}
	return true
}

func check(num []int , n int) bool {
	for i:=0; i<n; i++ {
		if num[i] != 9 {
			return false
		}
	}
	return true
}

func generateNextPalindrome(arr []int, n int) []int {
	answer := make([]int,  0)
	if check(arr, n) {
		for i:=0; i<=n; i++ {
			if i == 0 || i == n {
				answer = append(answer, 1)
			} else {
				answer = append(answer, 0)
			}
		}
		return answer
	}
	flag := right(arr, n)
	i := (n-1)/2
	j := n /2
	for i>=0 {
		if flag {
			if arr[i] == 9 {
				arr[i] = 0;
			} else {
				arr[i]++
				flag = false
			}
 		}
		arr[j] = arr[i]
		i--
		j++
	}
	for i=0; i<n; i++ {
		answer = append(answer, arr[i])
	}
	return answer
}

func main() {
	arr := []int{2,3,5,4,5}
	n := 5
	fmt.Println(generateNextPalindrome(arr, n))
}