package main

import (
	"bufio"
	"fmt"
	"os"
)

func betterString(str1, str2 string) string {
	return maxString(str1, str2, func(str string) int {
		return calculateValue(str)
	})
}

func calculateValue(s string) int {
	const mod = 1000000007
	visited := make([]int, 26)
	arr := make([]int, len(s)+1)
	arr[0] = 1

	for i := 1; i <= len(s); i++ {
		arr[i] = (arr[i-1] * 2) % mod
		if visited[s[i-1]-'a'] != 0 {
			arr[i] = (arr[i] - arr[visited[s[i-1]-'a']-1] + mod) % mod
		}
		visited[s[i-1]-'a'] = i
	}
	return arr[len(s)]
}

func maxString(str1, str2 string, evaluator func(string) int) string {
	if evaluator(str1) >= evaluator(str2) {
		return str1
	}
	return str2
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	// Taking the total count of test cases
	t := 0
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		// Reading the two strings
		var str1, str2 string
		scanner.Scan()
		str1 = scanner.Text()
		scanner.Scan()
		str2 = scanner.Text()

		// Getting the better string
		ans := betterString(str1, str2)
		fmt.Println(ans)
	}
}
