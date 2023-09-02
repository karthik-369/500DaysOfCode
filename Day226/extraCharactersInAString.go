package main

import "fmt"

func minExtraChar(s string, dictionary []string) int {
	memo := make(map[int]int)
	answer := dfs(s, dictionary, memo)
	return answer
}

func dfs(str string, dict []string, memo map[int]int) int {
	if len(str) == 0 {
		return 0
	}
	if val, ok := memo[len(str)]; ok {
		return val
	}
	min := len(str)
	for _, word := range dict {
		if str == word {
			min = 0
			memo[len(str)] = min
			return min
		} else if len(str) >= len(word) && str[:len(word)] == word {
			answer := dfs(str[len(word):], dict, memo)
			min = minInt(min, answer)
		}
	}
	answer := 1 + dfs(str[1:], dict, memo)
	min = minInt(min, answer)
	memo[len(str)] = min
	return min
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	s := "leetcode"
	dictionary := []string{"leet", "code"}
	fmt.Println(minExtraChar(s, dictionary)) // Output: 0
}
