package main

import (
	"fmt"
)

func fib(n int) int {
	if (n==1 || n == 2) {
		return 1
	}
	a := 1
	b := 1
	c := 0
	for i:=2; i<n; i++ {
		c = (a+b) % 1000000007
		a = b
		b = c
	}
	return c 
}

func main() {
	term := 1000
	fmt.Println(fib(term))
}