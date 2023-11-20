func garbageCollection(garbage []string, travel []int) int {
    im, ig, ip := -1, -1, -1
    cm, cg, cp := 0, 0, 0
    for i:=1; i<len(travel);i++ {
        travel[i] += travel[i-1]
    }
    for i:=0; i<len(garbage); i++ {
        for _, v:= range garbage[i] {
            if v == 'M' {
                im = i
                cm++
            } else if v == 'G' {
                ig = i
                cg++
            } else {
                ip = i
                cp++
            }
        }
    }
    // fmt.Println( im , ig, ip)
    // fmt.Println(cm ,cg, cp)
    // return 1
    answer := 0
    if cm != 0 && im != -1 {
        if im == 0 {
            answer += cm 
        } else {
            answer += (cm + travel[im-1])

        }
    }
    if cg != 0  && ig != -1 {
        if ig == 0 {
            answer += cg
        } else {
            
            answer += (cg + travel[ig -1])
        }
    }
    if cp != 0  && ip != -1{
        if ip == 0 {
            answer += cp
        } else {

            answer += (cp + travel[ip-1])
        }
    }
    return answer
}