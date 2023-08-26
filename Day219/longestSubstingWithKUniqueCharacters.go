package main

import (
	"fmt"
)

func longetsSubstring(str string, k int ) int {
	if len(str) == 0 || k == 0 {
		return 0
	}
	if (k>len(str)) {
		return -1
	}
	startIndex, endIndex := 0, 0
	answer := 0
	memory := make(map[byte]int)
	for endIndex < len(str) {
		if  _,is := memory[str[endIndex]]; !is{
			k--
		}
		memory[str[endIndex]] = endIndex
		for k < 0 {
			if memory[str[startIndex]] == startIndex {
				k++
				delete(memory, str[startIndex])
			}
			startIndex++
		}
		answer = max(answer, endIndex - startIndex + 1)
		endIndex++
	}
	return answer
}

func main() {
	str := "aabacbghjyelllloooobebe";
	k := 3;
	fmt.Println(longetsSubstring(str , k))
}