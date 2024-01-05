package main
import (
	"fmt"
)
func solve(n int, k int, target int, dp [][]int) int {
    if n > target || (n == 0 && target!=0 ) || n < 0 {
        return 0
    }
    if n == 0 && target == 0 {
        return 1
    }
    if dp[n][target] != -1 {
        return dp[n][target]
    }
    answer := 0
    for i:=1; i<=k; i++ {
        answer = (answer + solve(n-1, k, target-i, dp)) % 1000000007;
    }
    dp[n][target] = answer
    return answer
}

func numRollsToTarget(n int, k int, target int) int {
    if n > target { 
        return 0
    }
    dp := make([][]int, n+1)
    for i,_ := range dp {
        dp[i] = make([]int, target+1)
        for j,_ := range dp[i] {
            dp[i][j] = -1
        }
    }
    return solve(n, k, target, dp)
}

func main() {
	n1, k1, target1 := 1, 6, 3
	n2, k2, target2 := 2, 6, 7
	n3, k3, target3 := 30 ,30, 500
	fmt.Println(numRollsToTarget(n1, k1, target1))
	fmt.Println(numRollsToTarget(n2, k2, target2))
	fmt.Println(numRollsToTarget(n3, k3, target3))
}