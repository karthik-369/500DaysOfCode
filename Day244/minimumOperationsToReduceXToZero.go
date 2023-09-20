func minOperations(nums []int, x int) int {
    temp := 0
    for _, num := range nums {
        temp += num
    }
    t := temp - x
    if t < 0 {
        return -1
    }
    if t == 0 {
        return len(nums)
    }
    n := len(nums) 
    answer := math.MaxInt
    curr := 0
    li, ri := 0, 0
    for ri < n {
        curr += nums[ri]
        ri++
        for curr > t && li < n {
            curr -= nums[li]
            li++
        }
        if curr == t {
            answer = int(math.Min(float64(answer), float64(n-(ri - li))))
        }
    }
    if answer == math.MaxInt {
        return -1
    }
    return answer
}