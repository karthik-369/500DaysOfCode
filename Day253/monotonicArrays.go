func isMonotonic(nums []int) bool {
    increasing := true
    decreasing := true
    for i := 1; i < len(nums); i++ {
        if nums[i] > nums[i-1] {
            decreasing = false
        } else if nums[i] < nums[i-1] {
            increasing = false
        }
        if !increasing && !decreasing {
            return false
        }
    }
    return true 
}