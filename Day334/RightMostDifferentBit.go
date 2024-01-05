package main

import "fmt"

func posOfRightMostDiffBit(m, n int) int {
    if m == n {
        return -1
    }

    answer := 0
    diff := m ^ n

    for diff > 0 {
        answer++
        if diff&1 == 1 {
            break
        }
        diff >>= 1
    }

    return answer
}

func main() {
    var t, m, n int
    fmt.Scan(&t)

    for t > 0 {
        fmt.Scan(&m, &n)
        result := posOfRightMostDiffBit(m, n)
        fmt.Println(result)

        t--
    }
}
