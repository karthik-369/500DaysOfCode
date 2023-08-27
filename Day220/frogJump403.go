package main

import (
	"fmt"
)

func canCross(stones []int) bool {
    mapAndSet := make(map[int]map[int]bool)
    for i:=0; i<len(stones); i++ {
        mapAndSet[stones[i]] = make(map[int]bool)
    }
    mapAndSet[stones[0]][1] = true
    for i:=0; i<len(stones); i++ {
        curr := stones[i]
        stoneOrWater := mapAndSet[curr]
        for itr := range(stoneOrWater) {
            pos := itr + curr
            if pos == stones[len(stones)-1] {
                return true
            }
            if _, is := mapAndSet[pos]; is {
                if itr -1 > 0 {
                    mapAndSet[pos][itr-1] = true
                }
                mapAndSet[pos][itr] = true
                mapAndSet[pos][itr+1] = true
            }
        }
    }
    return false
}


func main() {
	arr := []int{0,1,3,5,6,8,12,17}
	fmt.Println(canCross(arr))
}