func findDifferentBinaryString(nums []string) string {
    l := len(nums[0])
    n := int( math.Pow(float64(2), float64(l)))
    set := make(map[string]bool)
    for _, v := range nums {
        set[v] = true
    }
    for i:=0; i<n; i++ {
        check := strconv.FormatInt(int64(i), 2)
        for len(check) < l {
            check = "0" + check
        }
        if _,flag := set[check]; !flag {
            return check
        }
    }
    return strconv.FormatInt(int64(len(nums)), 2)
}