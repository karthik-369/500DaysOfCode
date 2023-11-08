func isReachableAtTime(sx int, sy int, fx int, fy int, t int) bool {
    if sx == fx && sy == fy && t==1 {
        return false
    }
    temp := int (math.Max(math.Abs(float64(sx-fx)) , math.Abs(float64(sy-fy))))
    return t>= temp
}