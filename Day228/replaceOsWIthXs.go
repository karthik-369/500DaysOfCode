package  main

import (
	"fmt"
)

func fill(n int , m int, arr [][]byte) [][] byte {
	for i:=0; i<n; i++ {
		if arr[i][0] == 'O' {
			dfs(i, 0, arr, n, m)
		}
		if arr[i][m-1] == 'O' {
			dfs(i, m-1, arr, n, m)
		}
		for j:=0; j<m; j++ {
			if arr[0][j] == 'O' {
				dfs(0, j, arr, n, m)
			}
			if arr[n-1][j] == 'O' {
				dfs(n-1, j, arr, n, m)
			}
		}
	}
	for i:=0; i<n; i++ {
		for j:=0; j<m; j++ {
			if arr[i][j] == 'O' {
				arr[i][j] = 'X';
			}
			if arr[i][j] == '.' {
				arr[i][j] = 'O'
			}
		}
	}
	return arr
}

func dfs(i int, j int, arr [][] byte, r int , c int ) {
	if i<0 || j<0 || i>=r || j>=c || arr[i][j] == 'X' {
		return
	}
	if arr[i][j] == 'O' {
		arr[i][j] = '.'
		dfs(i-1, j, arr, r, c)
		dfs(i+1, j, arr, r, c)
		dfs(i, j-1, arr, r, c)
		dfs(i, j+1, arr, r, c)
	}
}

func main() {
	n := 5
	m := 4
	arr := [][]byte{{'X', 'X', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
	answer := fill(n, m, arr)
	for i:=0; i<len(answer); i++ {
		for j:=0; j<len(answer[0]); j++ {
			fmt.Print(string(answer[i][j]))
		}
		fmt.Println()
	}

}


