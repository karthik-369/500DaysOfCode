package main 

import (
	"fmt"
)

func findFirstSetBit(n int) int {
	if n == 0 {
		return 0
	} 
	answer := 1
	for n != 0 {
		if (n&1) == 0 {
			answer++
			n >>= 1
		} else {
			return answer
		}

	}
	return answer
}

func main() {
	fmt.Println(findFirstSetBit(8))
	
}