func numberOfBeams(bank []string) int {
    temp := 0
    answer := 0
    for _,v := range bank[0] {
        temp += int(v-'0')
    }
    for i:=1; i<len(bank); i++ {
        aTemp := 0
        for _,v := range bank[i] {
            aTemp += int(v-'0')
        }
        if aTemp != 0 {
            answer += aTemp*temp;
            temp = aTemp
        }
    }
    return answer
}