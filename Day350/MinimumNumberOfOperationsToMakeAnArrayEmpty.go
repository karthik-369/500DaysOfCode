func minOperations(nums []int) int {
    m := make(map[int]int)
    for _,v := range nums {
        m[v]++
    }
    answer := 0
    for _,v := range m {
        temp := v 
        if temp == 1 { 
            return -1
        }
        answer += temp /3;
        if temp %3 != 0 {
            answer++;
        }
    }
    return answer
}