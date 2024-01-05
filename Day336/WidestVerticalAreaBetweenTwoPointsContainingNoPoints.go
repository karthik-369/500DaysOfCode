func maxWidthOfVerticalArea(points [][]int) int {
    sort.Slice(points, func (i, j int) bool {
        if points[i][0] == points[j][0] {
            return points[i][1] < points[j][1]
        }
        return points[i][0] < points[j][0]
    })
    answer := math.MinInt
    for i:=1; i<len(points); i++ {
        answer = int(math.Max(float64(answer), float64(points[i][0] - points[i-1][0])))
    }
    return answer
}