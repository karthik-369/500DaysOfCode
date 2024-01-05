package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func nthPoint(n int) int {
	const mod = 1000000007
	if n == 1 {
		return 1
	}

	a := 2
	b := 3

	if n == 2 {
		return a
	}

	if n == 3 {
		return b
	}

	for i := 4; i <= n; i++ {
		temp := (a + b) % mod
		a = b
		b = temp
	}

	return b
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	if scanner.Scan() {
		T, _ := strconv.Atoi(scanner.Text())

		for T > 0 {
			if scanner.Scan() {
				n, _ := strconv.Atoi(scanner.Text())
				ans := nthPoint(n)
				fmt.Println(ans)
			}

			T--
		}
	}
}
