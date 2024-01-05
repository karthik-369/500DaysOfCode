func lengthOfLIS(nums []int) int {
    n := len(nums)
    arr := make([]int, n)
    answer := 1
    arr[0] = 1
    for i:=1; i<n; i++ {
        arr[i] = 1
        for j:=0; j<i; j++ {
            if nums[i] > nums[j] {
                arr[i] = int(math.Max(float64(arr[i]), float64(arr[j]+1)))
            }
        }
        answer = int(math.Max(float64(answer), float64(arr[i])))
    }
    return answer
}