func eliminateMaximum(dist []int, speed []int) int {
    arr := make([]float64, len(dist))
    for i:=0; i<len(dist); i++ {
        arr[i] = float64(dist[i])/float64(speed[i])
    }
    sort.Float64s(arr)
    for i:=0; i<len(dist); i++ {
        if arr[i] <= float64(i) {
            return i
        }
    }
    return len(dist)
}