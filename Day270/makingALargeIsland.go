package main

import (
	"fmt"
	"math"
)
func max (a, b int ) int {
	if a>b {
		return a
	}
	return b
}

func largestIsland(N int, grid [][]int) int {
	gp := make([][]int, N)
	var dir = [][]int{{-1,0}, {0,-1}, {1,0}, {0,1}}
	for i:= range gp {
		gp[i] = make([]int, N)
		for j:= range gp[i] {
			gp[i][j] = -1
		}
	}
	var valid func(i, j, N int) bool
	valid = func(i, j, N int) bool {
		if i>=N || i<0 || j>=N || j<0 {
			return false
		}
		return true
	}
	var set func(gp, grid [][]int , i, j, p, N int) int 
	set = func(dp, grid [][]int, i, j, p, N int) int {
		gp[i][j] = p
		count := 1
		for _, d := range dir {
			x, y := i+d[0], j+d[1]
			if valid(x, y, N) && grid[x][y] == 1 && gp[x][y] == -1 {
				count += set(gp, grid, x, y, p, N)
			}
		}
		return count 
	}
	
	answer := 0
	m := make(map[int]int)
	for i:=0; i<N; i++ {
		for j:=0; j<N; j++ {
			if grid[i][j] == 1 && gp[i][j] == -1 {
				p := i * N + j
				count := set(gp, grid, i, j, p ,N)
				m[p] = count
			}
		}
	}
	for i:=0; i<N; i++ {
		for j:=0; j<N; j++ {
			if grid[i][j] == 0 {
				dp := make(map[int]bool)
				for _, d := range dir {
					x, y := i+d[0], j + d[1]
					if valid(x, y, N) && grid[x][y] == 1 && !dp[gp[x][y]] {
						dp[gp[x][y]] = true
					}
				}
				temp :=0
				for pit := range dp {
					temp += m[pit]
				}
				answer = int(math.Max(float64(answer), float64(temp+1)))
			} else {
				answer = int(math.Max(float64(answer), float64(m[gp[i][j]])))
			}
		}
	}
	return answer
}

func valid(x, y, N int) {
	panic("unimplemented")
}

func main() {
	grid1 := [][]int{{1,0}, {0,1}}
	grid2 := [][]int{{1,1}, {1,0}}
	fmt.Println(largestIsland(2, grid1))
	fmt.Println(largestIsland(2, grid2))
}