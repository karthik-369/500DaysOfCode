package main

import (
	"fmt"
)

func VBTN(n int, leftChild []int, rightChild []int) bool {
	root := make(map[int]bool)
	for i:=0; i<n; i++ {
		if leftChild[i] != -1 {
			root[leftChild[i]] = true
		}
		if rightChild[i] != -1 {
			root[rightChild[i]] = true
		}
	}
	r := -1
	for i:=0; i<n; i++ { 
		if _, flag := root[i]; !flag {
			r = i
			break
		}
	}
	if r == - 1 {
		return false
	}
	queue := []int{r}
	visited := make([]bool, n)
	for len(queue) > 0 {
		num := queue[0]
		queue = queue[1:]
		if visited[num] {
			return false
		}
		visited[num] = true
		if leftChild[num] != -1 {
			queue = append(queue, leftChild[num])
		}
		if rightChild[num] != -1 {
			queue = append(queue, rightChild[num])
		}
	}
	l := 0
	for i:=0; i<n; i++ {
		if visited[i] {
			l++
		}
	}
	return l == n;
}

func main() {
	n1 := 4
	left1 := []int{1,-1,3,-1}
	right1 := []int{2,-1,-1, -1}
	n2 := 4
	left2 := []int{1,-1, 3, -1}
	right2 := []int{2,3,-1,-1}
	n3 := 4
	left3 := []int{3,-1,1,-1}
	right3 := []int{-1,-1,0,-1}
	fmt.Println(VBTN(n1, left1, right1))
	fmt.Println(VBTN(n2, left2, right2))
	fmt.Println(VBTN(n3, left3, right3))
}