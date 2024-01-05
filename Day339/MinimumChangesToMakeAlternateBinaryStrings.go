func minOperations(s string) int {
    a,b := 0, 0
    for i:=0; i<len(s); i++ {
        if i%2 == 0 {
            if s[i] == '0' {
                a++
            }
            if s[i] == '1' {
                b++
            }
        } else {
            if s[i] == '1' {
                a++
            }
            if s[i] == '0' {
                b++
            }
        }
    }
    return int(math.Min(float64(a), float64(b)))
}