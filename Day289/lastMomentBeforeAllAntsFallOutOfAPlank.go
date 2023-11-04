func getLastMoment(n int, left []int, right []int) int {
    min := math.MaxInt;
    max := math.MinInt;
    for i:=0; i<len(left); i++ {
        max = int(math.Max(float64(max), float64(left[i])))
    }
    for i:=0; i<len(right); i++ {
        min = int(math.Min(float64(min), float64(right[i])))
    }
    if min != math.MaxInt && max != math.MinInt {
        return int(math.Max(float64(n-min), float64(max)))
    }
    
    if min == math.MaxInt {
        return max
    }
    return n - min
}