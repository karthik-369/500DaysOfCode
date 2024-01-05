package main

import (
	"fmt"
)

func kSubContcat(n int, s string, k int) int {
	if n % k != 0 {
		return 0
	}
	
	set := make(map[string]bool)
	for i:=0; i<n; i+=k {
		if _,flag := set[s[i:i+k]]; !flag {
			set[s[i:i+k]] = true
		}
		
		if len(set)>2 {
			return 0
		}
	} 
	if len(set) == 2 || len(set) == 1 {
		return 1
	}
	return 0
}

func  main() {
	s1 := "bdac"
	s2 := "abcde"
	fmt.Println(kSubContcat(4, s1, 2))
	fmt.Println(kSubContcat(5, s2, 2))
}