package main

import (
	"fmt"
	"strings"
)

func fullJustify(words []string, maxWidth int) []string {
	answer := make([]string, 0)
	var wc, sl int
	for i:=0; i<len(words); i+=wc {
		sl = 0
		for wc=0; i+wc<len(words) && sl+len(words[i+wc])+wc<=maxWidth; wc++ {
			sl += len(words[i+wc])
		}
		str := words[i]
		if wc == 1 || i+wc == len(words) {
			for j:=1; j<wc; j++ {
				str += (" ") + words[i+j]
			}
			str += strings.Repeat(" ", maxWidth-len(str))
		} else {
			tab := (maxWidth - sl) / (wc - 1);
			extra := (maxWidth - sl) % (wc - 1);
			for j:=1; j<wc; j++ {
				ns := tab
				if extra >0 {
					extra -=1
					ns +=1
				}
				str += strings.Repeat(" ", ns) + words[i+j]
			}
		}
		answer = append(answer, str)
	}
	return answer
}

func main() {
	arr := []string{"This", "is", "an", "example", "of", "text", "justification."}
	maxWidth := 16;
	fmt.Println(fullJustify(arr, maxWidth))
}