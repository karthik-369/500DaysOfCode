type Pair struct {
	X, Y int
}

// isPathCrossing checks if the given path forms a crossing.
func isPathCrossing(path string) bool {
	set := make(map[Pair]struct{})
	x, y := 0, 0
	set[Pair{X: x, Y: y}] = struct{}{}

	for _, c := range path {
		switch c {
		case 'N':
			y++
		case 'S':
			y--
		case 'E':
			x++
		case 'W':
			x--
		}

		if _, exists := set[Pair{X: x, Y: y}]; exists {
			return true
		}

		set[Pair{X: x, Y: y}] = struct{}{}
	}

	return false
}
