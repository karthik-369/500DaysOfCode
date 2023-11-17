func minPairSum(nums []int) int {
    sort.Ints(nums)
    i, j := 0, len(nums) -1 
    answer := 0
    for i<j {
        answer = int(math.Max(float64(nums[i] + nums[j]),  float64(answer)))
        i++
        j--
    }
    return answer
}