func numberOfWays(corridor string) int {
    s, p := 0, 0
    answer := 1
    for i:=0; i<len(corridor); i++ {
        if corridor[i] == 'S' {
            s++
        } else {
            if s == 2 {
                p= (p+1)%1000000007
            }
        }
        if s == 3 {
            answer = (answer * ((p+1)%1000000007))%1000000007;
            s = 1
            p = 0
        }
    }
    // fmt.Println(s, answer)
    if s != 2 {
        return 0
    }
    return answer
}