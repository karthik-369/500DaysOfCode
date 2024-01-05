package main

import "fmt"

func maxL(a []int) (int, int, int) {
	sum := 0
	max := 0
	s := 0
	e := 0
	m := make(map[int]int)

	for i := 0; i < len(a); i++ {
		sum += a[i]

		if a[i] == 0 && max == 0 {
			s = i
			e = i
			max = 1
		}

		if sum == 0 {
			if max < i+1 {
				s = 0
				e = i
			}
			max = i + 1
		}

		if val, ok := m[sum]; ok {
			temp := max
			max = maxFunc(max, i-val)
			if max > temp {
				e = i
				s = val + 1
			}
		} else {
			m[sum] = i
		}
	}

	return max, s, e
}

func maxFunc(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func sumZeroMatrix(a [][]int) [][]int {
	r := len(a)
	c := len(a[0])
	sc := 0
	ec := 0
	sr := 0
	er := 0
	max := -1 << 31

	for i := 0; i < c; i++ {
		temp := make([]int, r)

		for j := i; j < c; j++ {
			for k := 0; k < r; k++ {
				temp[k] += a[k][j]
			}

			length, s, e := maxL(temp)
			area := (e - s + 1) * (j - i + 1)

			if length > 0 && area > max {
				sr = s
				er = e
				sc = i
				ec = j
				max = area
			}
		}
	}

	answer := make([][]int, 0)

	for i := sr; i <= er; i++ {
		temp := make([]int, 0)

		for j := sc; j <= ec; j++ {
			temp = append(temp, a[i][j])
		}

		answer = append(answer, temp)
	}

	return answer
}

func main() {
	// Example usage:
	matrix := [][]int{
		{9, 7, 16, 5},
		{1, -6, -7, 3},
		{1, 8, 7, 9},
		{7, -2, 0, 10},
	}

	result := sumZeroMatrix(matrix)
	fmt.Println(result)
}
