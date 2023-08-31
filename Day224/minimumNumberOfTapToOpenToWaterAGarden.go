package main
import (
	"fmt"
	"sort"
)
func minTaps(n int, ranges []int) int {
	arr := make([][]int, n+1)
	for i := range arr {
		arr[i] = make([]int, 2)
		arr[i][0] = max(0, i - ranges[i])
		arr[i][1] = min(n, i + ranges[i])
	}

	sort.Slice(arr, func(i, j int) bool {
		if arr[i][0]==arr[j][0]{
			return arr[j][1]<arr[i][1]
		}else{
			return arr[i][0]<arr[j][0]
		}
	})
	fmt.Println(arr)
	if arr[0][0]>0{
		return -1
	}
	end:=arr[0][1]
	count:=0
	for i:=range arr{
		count++
		if end>=n{
			return count
		}
		newEnd:=end
		for j:=i+1; j<len(arr); j++{
			if arr[j][0]<=end&&arr[j][1]>newEnd{
				i=j
				newEnd = arr[j][1]
			}
		}
		if newEnd==end{
			return -1
		}
		end = newEnd
		i--
	}
	return -1
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func main() {
	arr := []int{3,4,1,1,0,0}
	fmt.Println(minTaps(5,arr))
}