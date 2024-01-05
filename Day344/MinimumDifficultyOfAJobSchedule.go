func solve(i int, j int, jd []int, d int, arr [][]int) int {
	if j > d {
		return 1e9
	}
	if i == len(jd) {
		if j == d {
			return 0
		} else {
			return 1e9
		}
	}
	if arr[i][j] != -1 {
		return arr[i][j]
	}
	answer := int(1e9)
	max := jd[i]
	for k:=i; k<len(jd); k++ {
		max = int(math.Max(float64(max), float64(jd[k])))
		answer = int(math.Min(float64(answer), float64(max + solve(k+1, j+1, jd, d , arr))))
	}
	arr[i][j] = answer
	return arr[i][j]
}
func minDifficulty(jobDifficulty []int,d int ) int {
if len(jobDifficulty) < d {
		return -1
	}
	arr := make([][]int, 301)
	for i:=0; i<301; i++ {
		arr[i] = make([]int, 11)
	}
	for i:=0; i<=len(jobDifficulty); i++ {
		for j:=0; j<=d; j++ {
			arr[i][j] = -1
		}
	} 
	return solve(0, 0, jobDifficulty, d, arr)
}