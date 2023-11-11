package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t := parseInt(scanner.Text())

	for i := 0; i < t; i++ {
		scanner.Scan()
		s1 := scanner.Text()

		scanner.Scan()
		s2 := scanner.Text()

		result := areIsomorphic(s1, s2)
		if result {
			fmt.Println(1)
		} else {
			fmt.Println(0)
		}
	}
}

func areIsomorphic(str1, str2 string) bool {
	if len(str1) != len(str2) {
		return false
	}

	mapping := make(map[rune]rune)
	visited := make(map[rune]bool)

	for i, ch1 := range str1 {
		ch2 := rune(str2[i])

		if val, ok := mapping[ch1]; ok {
			if val != ch2 {
				return false
			}
		} else {
			if visited[ch2] {
				return false
			}
			mapping[ch1] = ch2
			visited[ch2] = true
		}
	}

	return true
}

func parseInt(s string) int {
	var result int
	fmt.Sscanf(s, "%d", &result)
	return result
}
