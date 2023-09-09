func count(nums []int, rem int, mem map[int]int) int {
    if val, found := mem[rem]; found {
        return val
    }
    if rem == 0 {
        return 1
    }
    if rem < mem[0] {
        return 0
    }
    c := 0
    for _, num:= range nums {
        if rem - num < 0 {
            break
        }
        c += count(nums, rem - num, mem)
    }
    mem[rem] = c
    return c
}

func combinationSum4(nums []int, target int) int {
    sort.Ints(nums)
    mem := make(map[int]int)
    return count(nums, target, mem)
}func count(nums []int, rem int, mem map[int]int) int {
    if val, found := mem[rem]; found {
        return val
    }
    if rem == 0 {
        return 1
    }
    if rem < mem[0] {
        return 0
    }
    c := 0
    for _, num:= range nums {
        if rem - num < 0 {
            break
        }
        c += count(nums, rem - num, mem)
    }
    mem[rem] = c
    return c
}

func combinationSum4(nums []int, target int) int {
    sort.Ints(nums)
    mem := make(map[int]int)
    return count(nums, target, mem)
}


func combinationSum4(nums []int, target int) int {
    if target == 0 {
        return 1
    }
    dp := make([]int, target + 1)
    dp[0] = 1
    l := len(nums)
    for i:= 1; i<=target; i++ {
        for j:=0; j<l; j++ {
            if nums[j] <= i {
                dp[i] = dp[i] + dp[i-nums[j]]
            }
        }
    }
    return dp[target]
}
