func maximumElementAfterDecrementingAndRearranging(arr []int) int {
    sort.Ints(arr)
    arr[0] = 1
    for i:=1; i<len(arr); i++ {
        arr[i] = int(math.Min(float64(arr[i-1]+1), float64(arr[i])))
    }
    return arr[len(arr)-1]
}