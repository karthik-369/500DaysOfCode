import "math"

func find132pattern(nums []int) bool {
    var stack []int
    third := math.MinInt32

    for i := len(nums) - 1; i >= 0; i-- {
        if nums[i] < third {
            return true
        }
        for len(stack) > 0 && stack[len(stack)-1] < nums[i] {
            third = stack[len(stack)-1]
            stack = stack[:len(stack)-1]
        }
        stack = append(stack, nums[i])
    }
    return false
}
