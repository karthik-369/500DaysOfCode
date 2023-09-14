package main

import (
	"fmt"
	"sort"
)

func findItinerary(tickets [][]string) []string {
    adj := make(map[string][]string)
    for _, i := range tickets {
        adj[i[0]] = append(adj[i[0]], i[1])
    }
    for key:= range adj {
        sort.Sort(sort.Reverse(sort.StringSlice(adj[key])))
    }
    answer := make([]string, 0)
    var dfs func(source string)
    dfs = func(source string) {
        for len(adj[source]) > 0 {
            to := adj[source][len(adj[source])-1]
            adj[source] = adj[source][:len(adj[source])-1]
            dfs(to)
        }
        answer = append(answer, source)
    }
    dfs("JFK")
    for i:=0 ; i<len(answer)/2; i++ {
        answer[i], answer[len(answer)-i-1] = answer[len(answer)-i-1], answer[i]
    }
    return answer
}
func main () {
	tickets := [][]string{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}}
	fmt.Println(findItinerary(tickets))
}