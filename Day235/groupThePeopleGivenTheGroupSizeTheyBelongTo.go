func groupThePeople(groupSizes []int) [][]int {
	m := make(map[int][]int)
	for i, size := range groupSizes {
		m[size] = append(m[size], i)
	}

	var res [][]int
	for size, indexes := range m {
		batch := []int{}
		for _, index := range indexes {
			batch = append(batch, index)
			if len(batch) == size {
				res = append(res, batch)
				batch = []int{}
			}
		}
		if len(batch) > 0 {
			res = append(res, batch)
		}

	}

	return res
}