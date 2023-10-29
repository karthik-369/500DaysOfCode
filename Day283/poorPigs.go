func poorPigs(buckets int, minutesToDie int, minutesToTest int) int {
    temp := minutesToTest / minutesToDie
    i := 0
    for int(math.Pow(float64(temp+1), float64(i))) < buckets {
        i++
    }
    return i
}