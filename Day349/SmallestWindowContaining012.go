package main

import (
	"bufio"
	"fmt"
	"os"
)

func smallestSubstring(S string) int {
	z, o, t := 0, 0, 0
	answer := int(^uint(0) >> 1) // MaxInt
	j := 0

	for i := 0; i < len(S); i++ {
		switch S[i] {
		case '0':
			z++
		case '1':
			o++
		case '2':
			t++
		}

		for z > 0 && o > 0 && t > 0 {
			answer = min(answer, i-j+1)

			switch S[j] {
			case '0':
				z--
			case '1':
				o--
			case '2':
				t--
			}

			j++
		}
	}

	if answer == int(^uint(0)>>1) {
		return -1
	}
	return answer
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	t := 0
	if scanner.Scan() {
		fmt.Sscan(scanner.Text(), &t)
	}

	for ; t > 0; t-- {
		var S string
		if scanner.Scan() {
			S = scanner.Text()
		}

		result := smallestSubstring(S)
		fmt.Println(result)
	}
}
