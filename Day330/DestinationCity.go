func destCity(paths [][]string) string {
    m := make(map[string]int)
    for _,v := range paths {
        m[v[0]]++
        m[v[1]]++
    }
    for _,v := range paths {
        if m[v[1]] == 1 {
            return v[1]
        }
    }
    return ""
}