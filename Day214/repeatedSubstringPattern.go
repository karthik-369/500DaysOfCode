package main

import (
	"fmt"
	"strings"
)


func rsp(str string) bool {
	n := len(str)
	for i:=n/2; i>0; i-- {
		if n%i==0 {
			temp := str[:i]
			var sb string
			len := n / i
			for j:=0; j<len; j++ {
				sb += temp
			}
			if sb == str {
				return true
			}
		}
	}
	return false
}

func orsp(str string) bool {
	n := len(str)
	for i:= n/2; i>0; i-- {
		if n%i == 0 && str[i-1] == str[n - 1] {
			temp := str[:i]
			len := n /i
			if strings.Repeat(temp, len) == str {
				return true
			}
		}
	}
	return false
}

func main() {
	str := "abcabcabcabc"
	fmt.Println(rsp(str))
}