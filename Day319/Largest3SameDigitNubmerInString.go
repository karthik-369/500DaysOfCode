func largestGoodInteger(num string) string {
    arr := make([]int, 10)
    for i:=0; i<len(num); i++ {
        if i+2 < len(num) {
            if num[i] == num[i+1] && num[i] == num[i+2] {
                arr[num[i]-'0']++
            }
        }
    }
    for i:=9; i>=0; i-- {
        if arr[i] != 0 {
            a := string(i+'0')
            return a+a+a
        }
    }
    return "";
}