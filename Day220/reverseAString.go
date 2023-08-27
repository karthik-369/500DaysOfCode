package main 

import (
	"fmt"
)

func reverse(s string) string {
	low := 0
	high := len(s) - 1
	arr:= make([]byte, len(s))
	for i:=0; i<len(s); i++ {
		arr[i] = byte(s[i])
	}
	for low <= high {
		arr[low] = s[high]
		arr[high] = s[low]
		low++
		high--
	}
	s = ""
	for i:=0; i<len(arr); i++ {
		s += string(arr[i])
	}
	return s
}

func main() {
	s := "hello"
	fmt.Println(reverse(s))
}