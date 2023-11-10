package main

import (
	"fmt"
)

func printMinimumNumberForPattern(S string) string {
	answer := ""
	stack := make([]int ,0)
	n := 1
	for _,v := range S {
		stack = append(stack, n)
		n++
		if v == 'I' {
			for len(stack) != 0 {
				answer += string(stack[len(stack)-1] + '0')
				stack = stack[0:len(stack)-1]
			}
		}
	}
	stack = append(stack, n)
	for len(stack) != 0 {
		answer += string(stack[len(stack) -1]+'0')
		stack = stack[0:len(stack)-1]
	}
	return answer
}

func main() {
	S1 := "D"
	S2 := "IIDIDD"
	fmt.Println(printMinimumNumberForPattern(S1))
	fmt.Println(printMinimumNumberForPattern(S2))
}