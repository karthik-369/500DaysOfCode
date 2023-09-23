package main 

import (
	"fmt"
	"sort"
)

// type Trie struct {
// 	next  [26]*Trie
// 	end bool
// 	branch  int
// }

// func maxInt(a int, b int) int {
// 	if (a > b) {
// 		return a
// 	}
// 	return b
// }

// func (trie *Trie) addWord(word string, pos int, branch int) {
// 	if pos  == len(word) {
// 		trie.end = true
// 		trie.branch = branch
// 		return
// 	} 
// 	temp := word[pos]
// 	if trie.next[temp-'a'] == nil {
// 		trie.next[temp-'a'] = &Trie{}
// 	}
// 	trie.next[temp-'a'].addWord(word, pos+1, branch)
// }

// func (trie *Trie) find (word string, pos int, flag bool) int {
// 	if pos == len(word) && flag {
// 		return trie.branch
// 	}
// 	max := 0
// 	for i:=0; i<26 && !flag; i++ {
// 		if trie.next[i] != nil {
// 			max = maxInt(max, trie.next[i].find(word, pos, true))
// 		}
// 	}
// 	if pos == len(word) {
// 		return max
// 	}
// 	temp := word[pos]
// 	if trie.next[temp-'a'] != nil {
// 		max = maxInt(max, trie.next[temp-'a'].find(word, pos+1, flag))
// 	}
// 	return max
// }

func longestStrChain(words []string) int {
	if len(words) == 1 {
		return 1
	}
	sort.Slice(words, func(i int, j int) bool {
		return len(words[i]) < len(words[j])
	})
	n := len(words)
	dp := make([]int, n) 
	for i:=0; i<n; i++ {
		dp[i] = 1
	}
	answer := 0
	for i:=1; i<n; i++ {
		start := sort.Search(i, func(j int) bool {
			return len(words[j]) >= len(words[i]) -1
		})
		for j:=start; j<i; j++ {
			if isPre(words[j], words[i]) {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		answer = max(answer, dp[i])
	}
	return answer
}

func isPre (a string, b string) bool {
	if len(a)+1 !=len(b) {
		return false
	}
	count := 0
	for i,j :=0, 0; i<len(a) && j < len(b); {
		if a[i] != b[j] {
			if count == 0 {
				count ++
				j++
			} else {
				return false
			}
		} else {
			i++
			j++
		}
	}
	return true
}

func main() {
	arr := []string{"a", "b", "ba", "bca", "bda", "bdca"}
	fmt.Println(longestStrChain(arr))
}