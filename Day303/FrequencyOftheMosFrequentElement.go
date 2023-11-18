func maxFrequency(nums []int, k int) int {
    left, max, sum := 0, 0, 0
    sort.Ints(nums)
    for r:=0; r<len(nums); r++ {
        sum += nums[r]
        for nums[r] * (r-left+1) - sum > k {
            sum -= nums[left]
            left++
        }
        max = int(math.Max(float64(max), float64(r-left+1)))
    }
    return max
}