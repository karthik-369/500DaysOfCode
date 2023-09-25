package main 

import (
	"fmt"
	"math"
)
func findTheDifference(s string, t string) byte {
    sSum, tSum := 0, 0
    for i:=0; i<len(s); i++ {
        sSum += int(s[i])
    }
    for i:=0; i<len(t); i++ {
        tSum += int(t[i])
    }
    // fmt.Println(sSum, tSum)
    return byte(math.Abs(float64(sSum)-float64(tSum)))
}


func main() {
	s := "abcd"
	t := "abcde"
	fmt.Println(string(findTheDifference(s, t)))
}