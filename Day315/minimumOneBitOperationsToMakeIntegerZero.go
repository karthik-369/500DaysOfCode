func minimumOneBitOperations(n int) int {
    if n <= 1 {
        return n
    }
    answer := 0
    for (1<<answer) <= n {
        answer++
    }
    return ((1<<answer)-1) - minimumOneBitOperations(n-(1<<(answer-1)))
    
}