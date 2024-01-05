package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func countWays(n, k int) int {
	if n == 1 {
		return k
	}

	const mod = 1000000007
	var temp, d int64
	d = int64(k)

	for i := 2; i <= n; i++ {
		t := temp
		temp = d
		d = (t + temp) * int64(k-1) % mod
	}

	return int((temp + d) % mod)
}

func main() {
	// Taking input using buffered reader
	scanner := bufio.NewScanner(os.Stdin)

	testcases := 0
	if scanner.Scan() {
		testcases, _ = strconv.Atoi(scanner.Text())
	}

	// looping through all testcases
	for testcases > 0 {
		// Read values for each testcase
		if scanner.Scan() {
			line := scanner.Text()
			a2 := splitAndConvertToInts(line)
			n := a2[0]
			k := a2[1]

			// Call the countWays function
			ans := countWays(n, k)
			fmt.Println(ans)
		}

		testcases--
	}
}

func splitAndConvertToInts(s string) []int {
	var result []int
	for _, v := range splitBySpace(s) {
		num, _ := strconv.Atoi(v)
		result = append(result, num)
	}
	return result
}

func splitBySpace(s string) []string {
	var result []string
	for _, v := range s {
		if v != ' ' {
			result = append(result, string(v))
		}
	}
	return result
}
