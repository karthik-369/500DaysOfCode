package main 

import (
	"fmt"
)

func palindrome(str string) bool {
	low := 0
	high := len(str) - 1
	for low <= high {
		if str[low] != str[high] {
			return false
		}
		low++
		high--
	}
	return true;
}

func main() {
	var str string
	fmt.Scanln(&str)
	fmt.Println(palindrome(str))
}