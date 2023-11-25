func getSumAbsoluteDifferences(nums []int) []int {
    answer := make([]int ,0)
    total := 0
    for _,v := range nums {
        total += v
    }
    pre, rem := 0, total
    for i,v := range nums {
        rem -= v
        answer = append(answer, rem - pre + (i *v) - ((len(nums)-i-1) * v))
        pre += v
    }
    return answer
}