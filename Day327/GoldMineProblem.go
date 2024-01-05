package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var dir = [][]int{{-1, -1}, {0, -1}, {1, -1}}

func maxGold(n, m int, M [][]int) int {
	arr := make([][]int, n)
	for i := range arr {
		arr[i] = make([]int, m)
		arr[i][0] = M[i][0]
	}

	for i := 1; i < m; i++ {
		for j := 0; j < n; j++ {
			temp := int(^uint(0) >> 1) // Max int value
			for k := 0; k < 3; k++ {
				x := j + dir[k][0]
				y := i + dir[k][1]
				if x >= 0 && x < n && y >= 0 && y < m {
					temp = max(temp, arr[x][y]+M[j][i])
				}
			}
			arr[j][i] = temp
		}
	}

	answer := int(^uint(0) >> 1) // Max int value
	for i := 0; i < n; i++ {
		answer = max(answer, arr[i][m-1])
	}
	return answer
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t, _ := strconv.Atoi(scanner.Text())

	for t > 0 {
		scanner.Scan()
		line1 := strings.Split(scanner.Text(), " ")
		n, _ := strconv.Atoi(line1[0])
		m, _ := strconv.Atoi(line1[1])

		scanner.Scan()
		line2 := strings.Split(scanner.Text(), " ")
		M := make([][]int, n)
		for i := range M {
			M[i] = make([]int, m)
			for j := range M[i] {
				val, _ := strconv.Atoi(line2[i*m+j])
				M[i][j] = val
			}
		}

		result := maxGold(n, m, M)
		fmt.Println(result)

		t--
	}
}
