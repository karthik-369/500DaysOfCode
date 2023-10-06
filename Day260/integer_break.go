func integerBreak(n int) int {
    if n == 2 { return 1 }
    if n == 3 { return 2 }
    
    count_of_3s := n / 3
    remainder := n % 3

    if remainder == 0 {
        return int(math.Pow(3, float64(count_of_3s)))
    } else if remainder == 1 {
        return int(math.Pow(3, float64(count_of_3s - 1))) * 4
    } else {
        return int(math.Pow(3, float64(count_of_3s))) * 2
    }
}
