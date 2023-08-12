package main

import (
	"fmt"
	"sort"
)

func longestSub(arr []int) int {
	ts := []int{arr[0]}
	for i:=1;i<len(arr);i++{
		if(arr[i]<ts[len(ts)-1]){
			ind := sort.SearchInts(ts, arr[i])
			if(ind!=len(ts)){
				copy(ts[ind+1:], ts[ind:])
				ts[ind] = arr[i]
			}
		}else{
			ts = append(ts, arr[i])
		}
	}
	return len(ts)
}

func main() {
	var arr = []int{6, 13, 7, 4, 8, 10}
	fmt.Println(longestSub(arr))
}
