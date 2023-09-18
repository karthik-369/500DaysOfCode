package main

import (
	"fmt"
)

func powerFunc(n int )  int {
	if n ==1 {
		return 1;
	}
	if n ==0 {
		return 0;
	}
	for n!=1 {
		if n%2 == 1 {
			return 0
		}
		n /= 2
	}
	return 1
}

func isPowerOfTwo(n int ) bool{
	if (powerFunc(n) == 1) {
		return true
	}
	return false
}

func is(n int ) bool {
	if n<=0 {
		return false
	}
	return (n&(n-1))==0
}

func main() {
	n := 10
	fmt.Println(isPowerOfTwo(n))
	fmt.Println(is(10))
}