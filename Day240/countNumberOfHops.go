package main 

import (
	"fmt"
)

func  countHops(n int) int {
	a, b, c := 1, 2, 4
	if (n==1) {
		return a
	} else if (n == 2) {
		return b
	} else if (n == 3) {
		return c
	}
	d := 0
	for i:=4; i<=n; i++ {
		d = ((a+b)%1000000007+c)%1000000007
		a = b
		b = c
		c = d
	}
	return c
}

func main() {
	n := 4
	fmt.Println(countHops(n))
}