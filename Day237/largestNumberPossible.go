package main

import (
	"fmt"
	"strconv"
)

func largestNumber(n, s int) string {
	if n * 9 < s || (s==0 && n>1) {
		return "-1"
	}
	var answer string
	arr := []int{0,1,2,3,4,5,6,7,8,9}
	var i int  = 9
	for n > 0 {
		if arr[i] > s {
			i--
		} else if arr[i] <= s {
			answer += strconv.Itoa(arr[i])
			n--
			s-=arr[i]
		}
	}
	fmt.Println(answer)
	if len(answer) == 0 || s != 0 {
		return "-1"
	}
	return answer
}

func main() {
	n := 2 
	s := 9
	fmt.Println(largestNumber(n, s))
}