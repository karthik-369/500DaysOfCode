package main

import (
	"fmt"
)


func getRow(rowIndex int) []int {
	temp := 1
	arr := make([]int, 0)
	arr = append(arr, temp)
	for i:=1; i<=rowIndex; i++ {
		num := (temp * (rowIndex-i+1))  /i;
		arr = append(arr, num)
		temp = num
	}

	return arr
}

func main() {
	rowIndex1 := 3
	rowIndex2 := 0
	rowIndex3 := 1
	fmt.Println(getRow(rowIndex1))
	fmt.Println(getRow(rowIndex2))
	fmt.Println(getRow(rowIndex3))
	

}