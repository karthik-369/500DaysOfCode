package main

import (
	"fmt"
)

func winner(str []string) []string {
	count := 0
	answer := ""
	m := make(map[string]int) 
	for _, v := range str {
		m[v]++
	}
	for k,v := range m {
		if answer == "" {
			answer = k
			count = v
		} else if count < v {
			answer = k
			count = v
		} else if count == v {
			if k < answer {
				answer = k
			}
		}
	}
	return []string{answer, fmt.Sprintf("%d",count)}
}

func main() {
	str1 := []string{"john","johnny","jackie","johnny","john","jackie","jamie","jamie","john","johnny","jamie","johnny","john"}
	str2 := []string{"andy","blake","clark"}
	fmt.Println(winner(str1))
	fmt.Println(winner(str2))
}