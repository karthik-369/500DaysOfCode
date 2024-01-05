package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func singleElement(arr []int, N int) int {
	countMap := make(map[int]int)

	for _, num := range arr {
		countMap[num]++
	}

	for key, count := range countMap {
		if count == 1 {
			return key
		}
	}

	return -1
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	t := 0

	if scanner.Scan() {
		t, _ = strconv.Atoi(scanner.Text())
	}

	for ; t > 0; t-- {
		N := 0

		if scanner.Scan() {
			N, _ = strconv.Atoi(scanner.Text())
		}

		arr := make([]int, N)

		if scanner.Scan() {
			input := scanner.Text()
			strArr := strings.Fields(input)

			for i := 0; i < N; i++ {
				arr[i], _ = strconv.Atoi(strArr[i])
			}
		}

		result := singleElement(arr, N)
		fmt.Println(result)
	}
}
