func findA(mat [][]int, i int) int {
    temp := -1
    for j:=0; j<len(mat[0]); j++ {
        if mat[i][j] == 1 {
            if temp >= 0 {
                return -1
            } else {
                temp = j
            }
        }
    }
    return temp
}

func findB(mat [][]int, i int, ind int) bool {
    for j:=0; j<len(mat); j++ {
        if mat[j][ind] == 1 && j != i {
            return false
        }
    }
    return true
} 

func numSpecial(mat [][]int) int {
    answer := 0
    for i:=0; i<len(mat); i++ {
        id := findA(mat, i)
        if id >=0 && findB(mat, i, id) {
            answer++
        }
    }
    return answer
}