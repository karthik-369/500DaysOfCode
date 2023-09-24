package main

import (
	"fmt"
	"math"
)

func champagneTower(poured int, query_row int, query_glass int) float64 {
	tower := make([][]float64, query_row+1)
	for i := range tower {
		tower[i] = make([]float64, i+1)
	}

	tower[0][0] = float64(poured)

	for i := 0; i < query_row; i++ {
		for j := 0; j <= i; j++ {
			excess := (tower[i][j] - 1) / 2.0
			if excess > 0 {
				tower[i+1][j] += excess
				tower[i+1][j+1] += excess
			}
		}
	}

	return math.Min(1.0, tower[query_row][query_glass])
}

func main() {
	poured := 2
	query_row := 1
	query_glass := 1
	fmt.Println(champagneTower(poured, query_row, query_glass))
}
