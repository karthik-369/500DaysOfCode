package main

import (
	"fmt"
)

func isPowerOfFour(n int)  bool {
	return n!=0 && (n &(n-1)) == 0 && (n&0xAAAAAAAA) == 0
}

func main() {
	n1 := 16
	n2 := 5
	n3 := 1
	fmt.Println(isPowerOfFour(n1))
	fmt.Println(isPowerOfFour(n2))
	fmt.Println(isPowerOfFour(n3))
}