package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func totalWays(N int) int {
	const mod = 1000000007
	arr1 := make([]int, N+1)
	arr2 := make([]int, N+1)

	arr1[1] = 1
	arr2[1] = 1

	for i := 2; i <= N; i++ {
		arr2[i] = (arr1[i-1] + arr2[i-1]) % mod
		arr1[i] = arr2[i-1]
	}

	answer := (arr1[N] + arr2[N]) % mod
	return (answer * answer) % 1000000007
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	T := 0

	if scanner.Scan() {
		T, _ = strconv.Atoi(scanner.Text())
	}

	for ; T > 0; T-- {
		N := 0

		if scanner.Scan() {
			N, _ = strconv.Atoi(scanner.Text())
		}

		ans := totalWays(N)
		fmt.Println(ans)
	}
}
