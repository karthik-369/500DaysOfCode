func getLengthOfOptimalCompression(s string, k int) int  {
	n := len(s)
	arr := map[[2]int]int{}
	for i:=1; i<=n; i++ {
		for j:=0; j<=k; j++ {
			curr := [2]int{i, j}
			arr[curr] = math.MaxInt
			count , temp := 0, 0
			for t:=i ;t>=1; t-- {
				if s[t-1] == s[i-1] {
					count++
				} else {
					temp++
				}
				if j- temp >= 0 {
					arr[curr] = solve(arr, curr, [2]int{t-1, j-temp}, count)
				}
			}
			if j > 0 {
				t := [2]int{i-1, j-1}
				if arr[t] < arr[curr] {
					arr[curr] = arr[t]
				}
			}
		}
	}
	return arr[[2]int{n, k}]
}
func solve(arr map[[2]int]int, ind, temp [2]int, count int) int {
	val := arr[temp]
	val++
	if count >= 100 {
		val+=3
	} else if count >= 10 {
		val+=2
	} else if (count >=2){
		val+=1
	}
	if arr[ind] < val {
		return arr[ind]
	}
	return val
}