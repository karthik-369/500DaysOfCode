package main

func topologicalSort(graph map[int][]int, ind []int) []int {
    visited := []int{} 
	stack := []int{}
    for key := range graph {
        if ind[key] == 0 {
            stack = append(stack, key)
        }
    }

    for len(stack) > 0 {
        cur := stack[len(stack) - 1]; stack = stack[:len(stack) - 1]
        visited = append(visited, cur)

        for _, prev := range graph[cur] {
            ind[prev]--
            if ind[prev] == 0 {
                stack = append(stack, prev)
            }
        }
    }

    if len(visited) == len(graph) {
        return visited
    }
    return []int{}
}

func sortItems(n int, m int, group []int, beforeItems [][]int) []int {
    gid := m
    for i := 0; i < n; i++ {
        if group[i] == -1 {
            group[i] = gid
            gid++
        }
    }

    ig := make(map[int][]int)
    itemind := make([]int, n)
    for i := 0; i < n; i++ {
		ig[i] = []int{}
	}

    gg := make(map[int][]int)
    groupind := make([]int, gid)
    for i := 0; i < gid; i++ {
		gg[i] = []int{}
	}

    for cur := 0; cur < n; cur++ {
        for _, prev := range beforeItems[cur] {
            ig[prev] = append(ig[prev], cur)
            itemind[cur]++

            if group[cur] != group[prev] {
                gg[group[prev]] = append(gg[group[prev]], group[cur])
                groupind[group[cur]]++
            }
        }
    }

    itemOrder := topologicalSort(ig, itemind)
    groupOrder := topologicalSort(gg, groupind)
    if len(itemOrder) <= 0 || len(groupOrder) <= 0 {
        return []int{}
    }

    ogr := make(map[int][]int)
    for _, item := range itemOrder {
        ogr[group[item]] = append(ogr[group[item]], item)
    }

    answerList := []int{}
    for _, groupIndex := range groupOrder {
        answerList = append(answerList, ogr[groupIndex]...)
    }

    return answerList
}