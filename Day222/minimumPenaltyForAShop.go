func bestClosingTime(customers string) int {
	var sum int32
	for i := 0; i < len(customers); i++ {
		if customers[i] == 'Y' {
			sum++
		}
	}
	result := -1
	min := sum
	for i := 0; i < len(customers); i++ {
		if customers[i] == 'Y' {
			sum--
		} else {
			sum++
		}
		if sum < min {
			min = sum
			result = i
		}
	}
	return result + 1
}

func bestClosingTime(customers string) int {
    l := len(customers)
    y, n := make([] int, l+1), make([] int, l+1)
    prey, pren := 0, 0
    for i:=0; i<l; i++ {
        if (customers[i] == 'Y') {
            prey++
        } else {
            pren++
        }
        y[i+1] = prey
        n[i+1] = pren
    }
    answer := 0
    for i:=1; i<=l; i++ {
        if prey - y[answer] + n[answer] > prey - y[i] + n[i] {
            answer = i
        } 
    }
    return answer
}