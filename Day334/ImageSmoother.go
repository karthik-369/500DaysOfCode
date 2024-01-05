func imageSmoother(img [][]int) [][]int {
    dir := [][]int{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,0}, {0,1}, {1,-1},{1,1}, {1,0}}
    answer := make([][]int, len(img))
    for i:=0; i<len(img); i++ {
        answer[i] = make([]int, len(img[0]))
        for j:=0; j<len(img[0]); j++ {
            temp := 0
            count := 0
            for _,v := range dir {
                x, y := i + v[0], j+v[1]
                if x>=0 && y>=0 && x<len(img) && y<len(img[0]) {
                    temp += img[x][y]
                    count++
                }
            }
            answer[i][j] = temp/count
        }
    }
        return answer
}