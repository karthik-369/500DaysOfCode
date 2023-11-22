func findDiagonalOrder(nums [][]int) []int {
    m := make(map[int][]int)
    for i,v := range nums {
        for j,t := range v {
            sum := i+j
            if _, flag := m[sum]; !flag {
                m[sum] = make([]int, 0)
            }
            m[sum] = append(m[sum], t)
        }
    }
    answer := make([]int, 0)
    for k:=0; k<len(m); k++ {
        if _,flag := m[k]; flag {
            for i:=len(m[k])-1; i>=0; i-- {
                answer = append(answer, m[k][i])
            }
        }
    }
    // fmt.Println(m)
    return answer
}