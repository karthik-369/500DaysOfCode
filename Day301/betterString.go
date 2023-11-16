package main

import (
	"fmt"
)

func betterString(str1 string, str2 string) string {
	return func(str string) int {
		visited := make([]int, 26)
		var arr = make([]int64, len(str)+1)
		const mod = 1000000007
		arr[0] = 1

		for i := 1; i <= len(str); i++ {
			arr[i] = (arr[i-1] * 2) % mod
			if visited[int(str[i-1]-'a')] != 0 {
				arr[i] = (arr[i] - arr[visited[int(str[i-1]-'a')]-1] + mod) % mod
			}
			visited[int(str[i-1]-'a')] = i
		}
		return int(arr[len(str)])
	}(str1) >= func(str string) int {
		visited := make([]int, 26)
		var arr = make([]int64, len(str)+1)
		const mod = 1000000007
		arr[0] = 1

		for i := 1; i <= len(str); i++ {
			arr[i] = (arr[i-1] * 2) % mod
			if visited[int(str[i-1]-'a')] != 0 {
				arr[i] = (arr[i] - arr[visited[int(str[i-1]-'a')]-1] + mod) % mod
			}
			visited[int(str[i-1]-'a')] = i
		}
		return int(arr[len(str)])
	}(str2) {
		return str1
	}
	return str2
}

func main() {
	var t int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		var str1, str2 string
		fmt.Scan(&str1)
		fmt.Scan(&str2)

		ans := betterString(str1, str2)
		fmt.Println(ans)
	}
}
