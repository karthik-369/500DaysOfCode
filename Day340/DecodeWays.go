func numDecodings(s string) int {
    l := len(s)
    arr := make([]int, l+1)
    if l == 0 || s[0] =='0' {
        return 0
    }
    arr[0] = 1
    arr[1] = 1
    for i:=2; i<=l; i++ {
        if s[i-1] >='1' && s[i-1] <='9' {
            arr[i] = arr[i-1];
        }
        if s[i-2] == '1' {
            arr[i] += arr[i-2]
        } else if s[i-2] == '2' && s[i-1] >= '0' && s[i-1]<='6' {
            arr[i] += arr[i-2]
        }
    }
        return arr[l]
}