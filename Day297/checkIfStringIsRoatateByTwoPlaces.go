package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t := parseInt(scanner.Text())

	for i := 0; i < t; i++ {
		scanner.Scan()
		s1 := scanner.Text()

		scanner.Scan()
		s2 := scanner.Text()

		obj := Solution{}
		flag := obj.isRotated(s1, s2)

		if flag {
			fmt.Println(1)
		} else {
			fmt.Println(0)
		}
	}
}

type Solution struct{}

func (s *Solution) isRotated(str1, str2 string) bool {
	if len(str1) == 0 {
		return false
	}
	if len(str1) == 1 {
		if str1 == str2 {
			return true
		}
		return false
	}

	temp := str1[2:] + string(str1[0]) + string(str1[1])
	if temp == str2 {
		return true
	}

	temp = string(str1[len(str1)-1]) + str1[:len(str1)-2]
	temp = string(str1[len(str1)-2]) + temp
	return temp == str2
}

func parseInt(s string) int {
	var result int
	fmt.Sscanf(s, "%d", &result)
	return result
}
