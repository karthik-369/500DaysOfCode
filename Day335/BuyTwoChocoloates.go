func buyChoco(prices []int, money int) int {
    min1, min2 := prices[0], math.MaxInt
    for _,v := range prices[1:] {
        if v < min1 {
            min2, min1 = min1, v
        } else if min2 > v {
                min2 = v
        }
    }
    // fmt.Println(min1, min2)
    if (min1 + min2) <= money {
        return money - min1 - min2
    }
    return money
}