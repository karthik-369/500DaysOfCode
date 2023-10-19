package main

import (
	"fmt"
)

func backspaceCompare(s string, t string) bool {
	temp1 := ""
	temp2 := ""
	for i:=0; i<len(s); i++ {
		if (s[i] == '#') {
			if len(temp1) != 0 {
				temp1 = temp1[:len(temp1)-1]
			}
			continue
			
		}
		temp1 += string(s[i])
	}
	for i:=0; i<len(t); i++ {
		if (t[i] == '#') {
			if len(temp2) != 0 {
				temp2 = temp2[:len(temp2)-1]
			}
			continue
		}
		temp2 += string(t[i])
	}
	fmt.Println(temp1 + " "+ temp2)
	return temp1 == temp2
}

func main() {
	s1 := "ab#c"
	t1 := "ad#c"
	s2 := "ab##"
	t2 := "c#d#"
	s3 := "a#c"
	t3 := "b"
	fmt.Println(backspaceCompare(s1,t1))
	fmt.Println(backspaceCompare(s2,t2))
	fmt.Println(backspaceCompare(s3,t3))
}