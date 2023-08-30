func minimumReplacement(nums []int) int64 {
    l := len(nums)
    e := nums[l - 1]
    var answer int64
    answer = 0
    for i:=l-2; i>=0; i-- {
        if nums[i] > e{
            temp := nums[i] /e;
            if nums[i] % e != 0 {
                temp++
            }
            e = nums[i] / temp
            answer += int64(temp) - 1
        } else {
            e = nums[i]
        }
    }
    return answer
}
