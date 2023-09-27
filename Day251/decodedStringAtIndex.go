package main

import (
	"fmt"
)

func decodeAtIndex(s string, k int) string {
	var n int64 = 0
	for i:=0; i<len(s); i++ {
		if s[i]>='0' && s[i]<='9' {
			n *= int64(s[i]-'0')
		} else {
			n++
		}
	}
	for i:=len(s)-1; i>=0; i-- {
		if s[i] >='0' && s[i]<='9' {
			n /= int64(s[i]-'0')
			k%=int(n)
		} else {
			if k == 0 || k == int(n) {
				return string(s[i])
			}
			n--
		}
	}
	return ""
} 

func main() {
	s1 := "leet2code3"
	k1 := 10
	s2 := "ha22"
	k2 := 5
	s3 := "a2345678999999999999999"
	k3 := 1
	fmt.Println(decodeAtIndex(s1, k1));
	fmt.Println(decodeAtIndex(s2, k2));
	fmt.Println(decodeAtIndex(s3, k3));
}