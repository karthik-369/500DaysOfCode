package main

import (
	"fmt"
)

func coinChange(coins []int, amount int)(int){
	dp:=make([]int , amount+1)
	dp[0] = 1
	for i:=0;i<len(coins);i++{
		for j:=coins[i];j<=amount;j++{
			dp[j] += dp[j - coins[i]]
		}
	}
	return  dp[amount]
}

func main() {
	// fmt.Println("Hail Hitler!")
	arr:= []int{1,2,3}
	amount:=4
	fmt.Println(coinChange(arr, amount))
}

