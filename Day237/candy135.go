package main

import (
	"fmt"
)

func candy(ratings []int) int {
	var n int = len(ratings)
	inc, dec, temp, tc := 0, 0, 0, 1
	for i:=1; i<n; i++ {
		if ratings[i-1] < ratings[i] {
			dec = 0;
			inc++
			temp = inc+1
			tc += temp
		} else if ratings[i-1] == ratings[i] {
			dec, inc, temp = 0, 0, 0
			tc++
		} else {
			dec++
			inc = 0
			tc+=dec +1
			if (temp > dec) {
				tc--
			}
		} 
	}
	return tc
}

func main() {
	arr := []int{1,0,2,5,6,4,5};
	fmt.Println(candy(arr))
}