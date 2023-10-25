func kthGrammar(n int, k int) int {
    if n == 1 {
       return 0
    }
    if k % 2 == 0 {
        if kthGrammar(n-1, k/2) == 0 {
            return 1
        } 
        return 0
    } else {
        if kthGrammar(n-1, (k+1)/2) == 0 {
            return 0
        }
        return 1
    }
}