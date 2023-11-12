func numBusesToDestination(routes [][]int, source int, target int) int {
    if source == target {
        return 0
    }
    if len(routes) == 1 {
        return -1
    }
    m := map[int][]int{}
    for i,r := range routes {
        for _,s := range r {
            if len(m[s]) == 0 {
                m[s] = []int{}
            }
            m[s] = append(m[s], i)
        } 
    }
    queue := [][]int{{source, 0}}
    visitedR := map[int]struct{}{}
    visitedS := map[int]struct{}{}
    for len(queue) != 0 {
        temp := queue[0]
        queue = queue[1:]
        if _, flag := visitedS[temp[0]]; flag {
            continue
        }
        visitedS[temp[0]] = struct{}{}
        if temp[0] == target {
            return temp[1]
        }
        arr := m[temp[0]]
        for _, n := range arr {
            if _, flag := visitedR[n]; flag {
                continue
            }
            for _, r := range routes[n] {
                queue= append(queue, []int{r, temp[1]+1})
            }
            visitedR[n] = struct{}{}
        }
    }
    return -1
}