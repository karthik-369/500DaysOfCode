func makeEqual(words []string) bool {
    l := len(words)
    arr := make([]int, 26)
    for _,v := range words {
        for _,c := range v {
            arr[c-'a']++
        }
    }
    for _,v := range arr {
        if v % l != 0 {
            return false
        }
    }
    return true
}