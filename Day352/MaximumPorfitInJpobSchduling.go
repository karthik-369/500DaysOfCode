package main

import (
	"fmt"
	"math"
	"sort"
)

type Pair struct {
	first, second int
}

type PairArray []Pair

func (a PairArray) Len() int {return len(a)}
func (a PairArray) Swap(i, j int) {a[i], a[j] = a[j], a[i]}
func (a PairArray) Less(i, j int) bool {return a[i].first < a[j].first}

func jobScheduling(startTime , endTime , profit []int) int {
	n := len(startTime)
	arr := make(PairArray, n)
	for i:=0; i<n; i++ {
		arr[i] = Pair{startTime[i], i}
	}
	sort.Sort(arr)
	dp := make([]int, n+1)
	for i:=n-1; i>=0; i-- {
		ni := sort.Search(n, func(j int) bool {
			return arr[j].first >= endTime[arr[i].second]
		})
		dp[i] = int(math.Max(float64(dp[i+1]), float64(profit[arr[i].second] + dp[ni])))
	}
	return dp[0]
}

func main() {
 	st1:= []int{1,2,3,3}
	et1:= []int{3,4,5,6}
	p1:= []int{50, 10, 40, 70}
	st2:= []int{1,2,3,4,6}
	et2:= []int{3,5,10,6, 9}
	p2:= []int{20, 20, 100, 70, 60}
	st3:= []int{1,1,1}
	et3:= []int{2,3,4}	
	p3:= []int{5,6,4}
	fmt.Println(jobScheduling(st1, et1, p1))
	fmt.Println(jobScheduling(st2, et2, p2))
	fmt.Println(jobScheduling(st3, et3, p3))
}