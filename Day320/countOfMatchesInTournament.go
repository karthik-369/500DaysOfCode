func numberOfMatches(n int) int {
    answer := 0
    for n != 0 {
        answer += n/2
        if n == 1 {
            n = 0
        }
        if n%2 == 0 {
            n/=2
        } else {
            n = (n/2) + 1
        }
    }   
    return answer
}