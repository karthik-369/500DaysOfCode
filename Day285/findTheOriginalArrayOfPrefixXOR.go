package main

import (
	"fmt"
)

func findArray(pref []int) []int {
	prev := pref[0]
    for i:=1; i<len(pref); i++ {
        temp := pref[i]
        pref[i] ^= prev
        prev = temp
    }
    return pref

}
func main() {
	arr1 := []int{5,2,0,3,1}
	arr2 := []int{13}
	fmt.Println(findArray(arr1))
	fmt.Println(findArray(arr2))
}