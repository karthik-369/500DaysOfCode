func minCost(colors string, neededTime []int) int {
    answer:= 0 
    max := neededTime[0]
    sum := neededTime[0]
    temp := colors[0]
    for i:=1; i<len(colors); i++ {
        if (temp == colors[i]) {
            // fmt.Println(sum)
            sum += neededTime[i]
            max = int(math.Max(float64(max), float64(neededTime[i])))
        } else {
            sum -= max;
            answer += sum;
            temp = colors[i]
            sum = neededTime[i]
            max = neededTime[i]
        }
        
    }
    answer += sum-max
    return answer
}