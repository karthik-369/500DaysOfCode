package main 

import (
	"fmt"
	"math"
)

func paintWalls (cost []int, time [] int) int {
	l := len(cost)
   arr := make([]int, l+1)
   for i:=0 ; i<=l ;i++ {
       arr[i] = int(1e9)
   }
   arr[0] = 0; 
   for i:=0 ;i<l; i++ {
       for j:=l; j>0; j-- {
           arr[j] = int(math.Min(float64(arr[j]), float64(arr[int(math.Max(float64(j - time[i]-1), float64(0)))] + cost[i])))
       }
   }
   return arr[l]
}

func main() {
	cost1 := []int{1,2,3,2}
	time1 := []int{1,2,3,2}
	cost2 := []int{2,3,4,2}
	time2 := []int{1,1,1,1}
	cost3 := []int{26,53,10,24,25,20,63,51}
	time3 := []int{1,1,1,1,2,2,2,}
	fmt.Println(paintWalls(cost1, time1))
	fmt.Println(paintWalls(cost2, time2))
	fmt.Println(paintWalls(cost3, time3))
}