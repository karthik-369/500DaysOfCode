package main

import "fmt"

func minCandy(N int, ratings []int) int {
	answer := make([]int, N)
	for i := 0; i < N; i++ {
		answer[i] = 1
	}

	for i := 1; i < N; i++ {
		if ratings[i-1] < ratings[i] && answer[i-1] >= answer[i] {
			answer[i] = answer[i-1] + 1
		}
	}

	for i := N - 2; i >= 0; i-- {
		if ratings[i+1] < ratings[i] && answer[i+1] >= answer[i] {
			answer[i] = answer[i+1] + 1
		}
	}

	ans := 0
	for i := 0; i < N; i++ {
		ans += answer[i]
	}

	return ans
}

func main() {
	var T, N, rating int
	fmt.Scan(&T)

	for T > 0 {
		fmt.Scan(&N)
		ratings := make([]int, N)
		for i := 0; i < N; i++ {
			fmt.Scan(&rating)
			ratings[i] = rating
		}
		result := minCandy(N, ratings)
		fmt.Println(result)

		T--
	}
}
