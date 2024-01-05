package main

import (
	"fmt"
)

func isAlpha(temp byte) bool {
	return (temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')
}

func match(wild, pattern string) bool {
	i, j := 0, 0
	l1, l2 := len(wild), len(pattern)

	for i < l1 && j < l2 {
		if isAlpha(wild[i]) && isAlpha(pattern[j]) && wild[i] != pattern[j] {
			return false
		} else if wild[i] == '*' {
			if i == l1-1 {
				return true
			}
			if wild[i+1] == pattern[j] && wild[i+1] != pattern[j+1] {
				i++
				continue
			}
			i++
			j++

			if wild[i] == '?' && wild[i+1] == pattern[j+1] {
				i++
				j++
				continue
			}
			for j < l2 && wild[i] == '?' && wild[i+1] != pattern[j+1] && isAlpha(wild[i+1]) {
				j++
			}
			for wild[i] == '*' {
				i++
				j++
			}
