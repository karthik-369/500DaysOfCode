package main

import (
	"fmt"
)

func countNicePairs(nums []int) int {
    m := make(map[int]int)
    for _,v := range nums {
        temp := v - reverse(v)
        if _, flag := m[temp]; flag {
            m[temp]++
        } else {
            m[temp] = 1
        }
    }
    answer := 0
	mod := 1000000007
	for _,v := range m {
		answer = (answer % mod + (v*v-1)/2) %mod
	}
	return answer
}

func reverse(v int) int {
    answer := 0
    for v != 0 {
        answer = (answer * 10 + v %10)
        v /=10;
    }
    return answer
}

func main() {
	arr1 := []int{42,11,1,97};
	fmt.Println(countNicePairs(arr1))
}