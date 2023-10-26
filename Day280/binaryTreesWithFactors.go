package main

import (
	"fmt"
	"sort"
)
func numFactoresBinaryTrees(arr []int) int {
	mod := 1000000007
	sort.Ints(arr)
	a := make([]int, len(arr))
	for i,_ := range a {
		a[i] =1
	}
	m := make(map[int]int)
	for i,v := range arr {
		m[v] = i
	}
	for i:=0; i<len(arr); i++ {
		for j:=0; j<i; j++ {
			if arr[i] % arr[j] == 0 {
				temp := arr[i] /arr[j];
				if _, flag := m[temp]; flag {
					a[i] = (a[i]+a[j]*a[m[temp]])%mod
				}
			}
		}
	}
	answer := 0
	for _,v := range a {
		answer = (answer + v)%mod;
	}
	return answer
}
func main() {
	arr1 := []int{2,4}
	arr2 := []int{2,4,5,10}
	arr3:= []int{18,3,6,2}
	fmt.Println(numFactoresBinaryTrees(arr1));
	fmt.Println(numFactoresBinaryTrees(arr2));
	fmt.Println(numFactoresBinaryTrees(arr3));

}