func countPalindromicSubsequence(s string) int {
    answer :=0 
    // l := len(s)
    
    for c:= 'a'; c<='z'; c++ {
        first := strings.Index(s, string(c))
        last := strings.LastIndex(s, string(c))
        if first!= -1 && last !=-1  && first < last {
            set := make(map[byte]bool)
            for i:=first+1; i<last; i++ {
                set[s[i]] =  true
            }
            answer += len(set)
        }
    }
    return answer
}