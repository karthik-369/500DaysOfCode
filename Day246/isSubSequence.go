package main

import (
	"fmt"
)

func isSubsequence(s string, t string) bool {
	i, j := 0, 0
	for i<len(s) && j<len(t) {
		if (s[i] == t[j]) {
			i++
			j++
		} else {
			j++
		}
	}
	return i == len(s)
}

func main() {
	s := "abc"
	t := "ahbgdc"
	fmt.Println(isSubsequence(s, t))
}