package main

import (
	"bufio"
	"fmt"
	"os"
)

func areRotations(s1, s2 string) bool {
	return strings.Contains(s1+s1, s2)
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	// Taking the total count of test cases
	t := 0
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		// Reading the two strings
		var s1, s2 string
		scanner.Scan()
		s1 = scanner.Text()
		scanner.Scan()
		s2 = scanner.Text()

		// Checking if the strings are rotations
		if areRotations(s1, s2) {
			fmt.Println("1")
		} else {
			fmt.Println("0")
		}
	}
}
