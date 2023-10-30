func sortByBits(arr []int) []int {
    sort.Slice(arr, func(i, j int ) bool {
        temp1 := bits.OnesCount(uint(arr[i]))
        temp2 := bits.OnesCount(uint(arr[j]))
        if temp1 != temp2 {
            return temp1 < temp2
        }
        return arr[i] < arr[j]
    })
    return arr
}
