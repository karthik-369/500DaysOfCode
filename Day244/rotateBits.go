package main

import (
	"fmt"
	"math"
)

func rotate(n int, d int ) []int {
	answer := make([]int, 0)
	d %= 16
	answer = append(answer, ((n<<d) | (n<<(16-d))) & (int(math.Pow(2, 16))-1))
	answer = append(answer, ((n>>d) | (n>>(16-d))) & (int(math.Pow(2, 16))-1))
	return answer
}

func main() {
	fmt.Println(rotate(28, 2))
	fmt.Println(rotate(18, 2))
	fmt.Println(rotate(234, 34))
}