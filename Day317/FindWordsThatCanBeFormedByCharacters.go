func flag(word string, arr []int) bool {
    temp := make([]int, 26)
    for i:=0; i<len(word); i++ {
        x := word[i]-'a'
        temp[x]++
        if temp[x] > arr[x] {
            return false
        }
        
    }
    return true
}

func countCharacters(words []string, chars string) int {
    arr := make([]int, 26)
    for i:=0; i<len(chars); i++ {
        arr[chars[i]-'a']++
    }
    answer := 0
    for _,v:= range words {
        if flag(v, arr) {
            answer += len(v)
        }
    }
    return answer
}