func sortVowels(s string) string {
    arr := []rune(s)
    ind := make([]int,0)
    vow := make([]int, int('u'-'A')+1)
    for i, v := range s {
        if v == 'a' || v=='e' || v=='i' || v=='o' || v=='u' || v=='A' || v=='E' || v=='I' || v=='O' || v=='U' {
            ind = append(ind, i)
            vow[int(v-'A')]++
        }
    }
    p := 0
    for i,v := range vow {
        if v == 0 {
            continue
        } 
        for j:=0; j<v; j++ {
            arr[ind[p]] = rune(i)+'A'
            p++
        }
    }
        return string(arr)
}
