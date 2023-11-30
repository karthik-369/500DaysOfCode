func hammingWeight(num uint32) int {
    answer := 0
    for num != 0 {
        lsb := num & 1
        answer += int(lsb)
        num=num>>1
    }
    return answer
}