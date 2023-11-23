func isArr(nums []int) bool {
    // fmt.Println(nums)
    sort.Ints(nums)
    diff := nums[1] - nums[0]
    for i:=2; i<len(nums); i++ {
        if (nums[i]-nums[i-1]) != diff {
            return false
        }
    }
    return true
}
func checkArithmeticSubarrays(nums []int, l []int, r []int) []bool {
    answer := make([]bool, len(l))
    for i:=0; i<len(r); i++ {
        // fmt.Println(nums)
        temp := make([]int, (r[i] - l[i])+1)
        copy(temp, nums[l[i]:r[i]+1])
        if isArr(temp) {
            answer[i] = true
        }
    }
    return answer
}