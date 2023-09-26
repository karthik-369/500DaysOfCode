package main 

import (
	"fmt"
)

func removeDuplicateLetters(s string) string {
	var answer []rune

	visited := make([]bool, 26)
	arr := make([]int, 20)

	for _,v := range s {
		arr[v - 'a']++
	}
	// fmt.Println(arr)

	stack := []rune{}

	for _, v := range s {
		if visited[v-'a'] {
			arr[v-'a']--
			continue
		}
		for len(stack) > 0 && stack[len(stack)-1] > v && arr[stack[len(stack)-1]-'a'] > 0 {
			visited[stack[len(stack)-1] - 'a'] = false
			stack = stack[:len(stack)- 1]
		}

		stack = append(stack, v)
		visited[v - 'a'] = true
		arr[v - 'a']--
	}
	// fmt.Println(visited)
	// fmt.Println(stack)

	for _, v := range stack {
		answer = append(answer, v)
	}

	return string(answer)
}

func main() {
	str1 :="bcabc" 
	str2 := "cbacdcbc"
	str3 := "cdadabcc"
	fmt.Println(removeDuplicateLetters(str1))
	fmt.Println(removeDuplicateLetters(str2))
	fmt.Println(removeDuplicateLetters(str3))
}