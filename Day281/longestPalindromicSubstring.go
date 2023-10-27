func longestPalindrome(s string) string {
    answer := 0
    l, h := 0, 0
    le := len(s)
    for i:=1; i<le; i ++ {
        sp, ep := i-1, i+1
        for (sp>=0 && ep<le) && (s[sp] == s[ep]) {
            if ep-sp+1 > answer {
                answer = ep-sp+1
                l = sp
                h = ep
            }
            sp--
        ep++
        }
        sp = i-1
        ep = i
        for (sp>=0 && ep<le) && (s[sp] == s[ep]) {
            if ep-sp+1 > answer {
                answer = ep-sp+1
                l = sp
                h = ep
            }
            sp--
            ep++
        }    
    }
    ans := ""
    for i:=l; i<=h; i++ {
        ans += string(s[i])
    }
    return ans
    
}