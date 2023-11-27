func knightDialer(n int) int {
    n--
    pos := make([]int , 10)
    for i := range pos {
        pos[i] = 1
    }
    for n > 0 {
        temp := make([]int, 10)
        temp[0] = (pos[4] + pos[6]) % 1000000007
        temp[1] = (pos[6] + pos[8]) % 1000000007
        temp[2] = (pos[7] + pos[9]) % 1000000007
        temp[3] = (pos[4] + pos[8]) % 1000000007
        temp[4] = (pos[3] + pos[9] + pos[0]) % 1000000007
        temp[6] = (pos[1] + pos[7] + pos[0]) % 1000000007
        temp[7] = (pos[2] + pos[6]) % 1000000007
        temp[8] = (pos[1] + pos[3]) % 1000000007
        temp[9] = (pos[2] + pos[4]) % 1000000007   
        pos = temp
        n--     
    }
    answer := 0
    for _,v := range pos {
        answer  = (answer + v) % 1000000007
    }
    return answer
}