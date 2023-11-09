func countHomogenous(s string) int {
    answer := 0
    count := 1
    mod := 1000000007
    for i:=0; i<len(s)-1; i++ {
        if (s[i] !=s[i+1]) {
            answer = (answer   +  ((count*(count+1)%mod) % mod) / 2)%mod
            count = 1
        } else {
            count++
            count %= mod
        }
    }
    answer = (answer   +  ((count*(count+1)%mod) % mod) / 2)%mod
    return answerS
}