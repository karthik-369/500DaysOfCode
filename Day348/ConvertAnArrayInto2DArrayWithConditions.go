func findMatrix(nums []int) [][]int {
    temp := make([]int, len(nums)+1)
    answer := make([][]int, 0)
    for _,v := range nums {
        if temp[v] >= len(answer) {
            answer = append(answer, make([]int, 0))
        }
        answer[temp[v]] = append(answer[temp[v]], v)
        temp[v]++
    }
    return answer
}
