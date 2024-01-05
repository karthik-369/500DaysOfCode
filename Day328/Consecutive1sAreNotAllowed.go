package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func countStrings(n int) int {
	const mod = 1000000007
	var prev, answer int64 = 1, 2

	for i := 1; i < n; i++ {
		temp := answer
		answer = (answer + prev) % mod
		prev = temp
	}

	return int(answer)
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t, _ := strconv.Atoi(scanner.Text())

	for t > 0 {
		scanner.Scan()
		n, _ := strconv.Atoi(scanner.Text())

		result := countStrings(n)
		fmt.Println(result)

		t--
	}
}
