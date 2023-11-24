package main

import (
	"fmt"
	"sort"
)

func maxCoins(piles[] int) int {
	sort.Ints(piles)
    answer := 0
    // fmt.Println(piles)
    for i:=len(piles)/3;i<len(piles); i+=2 {
        answer += piles[i]
    }
    return answer
}

func main() {
	piles1 := []int{2,4,1,2,7,8}
	piles2 := []int{2,4,5}
	piles3 := []int{9,8,7,6,5,1,2,3,4}
	fmt.Println(maxCoins(piles1))	
	fmt.Println(maxCoins(piles2))
	fmt.Println(maxCoins(piles3))


}