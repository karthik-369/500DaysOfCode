package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	t, _ := strconv.Atoi(readLine(reader))
	for t > 0 {
		inputLine, _ := reader.ReadString('\n')
		inputLine = strings.TrimSpace(inputLine)
		input := strings.Split(inputLine, " ")
		M, _ := strconv.Atoi(input[0])
		N, _ := strconv.Atoi(input[1])
		result := NumberOfPaths(M, N)
		fmt.Println(result)
		t--
	}
}

func NumberOfPaths(M, N int) int {
	Mod := 1000000007
	var path int64 = 1
	for i := 0; i < M-1; i++ {
		path = (path * int64(i+N)) % int64(Mod)
		temp := power(int64(i+1), int64(Mod-2), int64(Mod))
		path = (path * temp) % int64(Mod)
	}
	return int(path)
}

func power(base, exponent, mod int64) int64 {
	var result int64 = 1
	for exponent > 0 {
		if exponent%2 == 1 {
			result = (result * base) % mod
		}
		base = (base * base) % mod
		exponent /= 2
	}
	return result
}

func readLine(reader *bufio.Reader) string {
	line, _ := reader.ReadString('\n')
	return strings.TrimSpace(line)
}
