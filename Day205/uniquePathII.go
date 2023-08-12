package main

import "fmt"

var answer []int
//MLE
func dfs(grid[][] int , i int , j int , r int , c int ) {
	if i == r-1 && j == c-1 {
		answer = append(answer , 0)
		return;
	}
	if i+1 < r && grid[i+1][j] != 1 {
		dfs(grid, i+1, j, r, c)
	}
	if j+1 < c && grid[i][j+1] != 1 {
		dfs(grid, i, j+1, r, c)
	}
}
//TLE
func dfsIII(grid [][]int , i int, j int , r int , c int ) int {
	if i == r-1 && j == c - 1{
		return 1
	}
	if i>=r || j >=c || grid[i][j] == 1 {
		return 0
	}
	return dfsIII(grid, i+1, j, r, c) + dfsIII(grid, i, j+1, r, c)
}

func uniquePathsWithObstacles(grid [][]int) int {
	if grid[0][0] == 1 {
		return 0
	}
	answer = []int{}
	dfs(grid, 0, 0, len(grid), len(grid[0]))
	return len(answer)
}

func dfsII(obstacleGrid [][]int, arr [][] int, i int, j int, r int, c int) int {
    if i == r || j == c || obstacleGrid[i][j] == 1 {
        return 0
    }
    if i == r-1 && j == c-1 {
        return 1
    }
    if arr[i][j] > 0 {
        return arr[i][j]
    }
    current := 0
    current += (dfsII(obstacleGrid, arr, i+1, j, r, c) + dfsII(obstacleGrid, arr, i, j+1, r, c))
    arr[i][j] = current
    return current
}

func dfsMemo(grid [][]int) int {
	r := len(grid)
	c := len(grid[0])
	dp := make([][] int, r)
	for i:=range dp {
		dp[i] = make([] int, c)
	}
	for i:=0 ;i<r && grid[i][0] == 0; i++ {
		dp[i][0] = 1
	}
	for i:=0 ;i<c && grid[0][i] == 0; i++ {
		dp[0][i] =1
	}
	for i:=1; i<r; i++ {
		for j:=1; j<c; j++ {
			if grid[i][j] == 0 {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]
			}
		}
	}
	return dp[r-1][c-1]
}

func uniquePathsWithObstaclesII(grid [][]int) int {
	r := len(grid)
	c := len(grid[0])
	if(grid[0][0] == 0){
		return 0
	}
	arr := make([][]int ,r)
	for i:=0; i<r; i++{
		arr[i] = make([]int, c)
	}
	return dfsII(grid, arr, 0, 0, r, c);
}



func main() {
	grid := [][]int{{0,0,0},{0,1,0},{0,0,0}};
	//TLE
	fmt.Println(uniquePathsWithObstacles(grid));
	fmt.Println(uniquePathsWithObstaclesII(grid));
}