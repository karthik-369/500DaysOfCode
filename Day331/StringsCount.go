package main

import "fmt"

func countStr(n int64) int64 {
	a := int64(1)
	b := n
	c := n
	d := n * (n - 1)
	e := (n * (n - 1)) / 2
	f := (n * (n - 1) * (n - 2)) / 2
	return a + b + c + d + e + f
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var n int64
		fmt.Scan(&n)

		result := countStr(n)
		fmt.Println(result)

		t--
	}
}
