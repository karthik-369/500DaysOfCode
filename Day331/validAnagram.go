func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    arr := [26]int{}
    arr2 := [26]int{}
    for i:=0; i<len(t); i++ {
        arr[s[i]-'a']++
        arr2[t[i]-'a']++
    }
    return arr == arr2
}