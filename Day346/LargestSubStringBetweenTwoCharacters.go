func maxLengthBetweenEqualCharacters(s string) int {
    m := make(map[rune]int)
    answer := 0
    for i,v := range s {
        if _,flag:= m[v]; flag {
            answer = int(math.Max(float64(answer), float64(i - m[v])))
        } else {
            m[v] = i
        }
    }
    return answer-1
}