package main

import (
	"fmt"
	"strconv"
)

func isSumString(s string) int {
	for i := 1; i < len(s); i++ {
		for j := 1; j < len(s)-i; j++ {
			if find(s, 0, i, j) {
				return 1
			}
		}
	}
	return 0
}

func find(s string, pos, i, j int) bool {
	temp1 := s[pos : pos+i]
	temp2 := s[pos+i : pos+j+i]
	temp3 := sum(temp1, temp2)

	if len(temp3) > len(s)-pos-i-j {
		return false
	}

	if s[pos+i+j:pos+i+j+len(temp3)] == temp3 {
		if pos+i+j+len(temp3) == len(s) {
			return true
		}
		return find(s, pos+i, j, len(temp3))
	}

	return false
}

func sum(s1, s2 string) string {
	i, j := len(s1)-1, len(s2)-1
	var answer string
	c := 0

	for i >= 0 && j >= 0 {
		x, _ := strconv.Atoi(string(s1[i]))
		y, _ := strconv.Atoi(string(s2[j]))
		temp := x + y + c
		rem := temp % 10
		c = temp / 10
		answer = strconv.Itoa(rem) + answer
		i--
		j--
	}

	for i >= 0 {
		x, _ := strconv.Atoi(string(s1[i]))
		temp := x + c
		rem := temp % 10
		c = temp / 10
		answer = strconv.Itoa(rem) + answer
		i--
	}

	for j >= 0 {
		x, _ := strconv.Atoi(string(s2[j]))
		temp := x + c
		rem := temp % 10
		c = temp / 10
		answer = strconv.Itoa(rem) + answer
		j--
	}

	for c > 0 {
		rem := c % 10
		answer = strconv.Itoa(rem) + answer
		c /= 10
	}

	return answer
}

func main() {
	var t int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		var s string
		fmt.Scan(&s)

		result := isSumString(s)
		fmt.Println(result)
	}
}
