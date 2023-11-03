func buildArray(target []int, n int) []string {
	s := 1
	answer := make([]string, 0)
	for _,v := range target {
		for s < v {
			answer = append(answer, "Push")
			answer = append(answer, "Pop")
			s++
		}
		s++
		answer = append(answer, "Push")
	}
	return answer
 }