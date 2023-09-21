package main

import (
	"fmt"
	"math"
)

func findMedianSortedArrays(nums1 []int, nums2 [] int) float64 {
	x := len(nums1)
	y := len(nums2)
	if x > y {
		return findMedianSortedArrays(nums2, nums1)
	}
	low, high  := 0, x
	for low <= high {
		pX := high - ((high-low)>>1)
		pY := (x+y+1) / 2 - pX
		maxX := math.MinInt
		maxY := math.MinInt
		minX := math.MaxInt
		minY := math.MaxInt
		if pX != 0 {
			maxX = nums1[pX-1] 
		}
		if pY != 0 {
			maxY = nums2[pY-1]
		}
		if pX != x {
			minX = nums1[pX]
		}
		if pY != y {
			minY = nums2[pY]
		}
		if maxX <= minY && maxY <= minX {
			if ((x+y)%2 == 0) {
				return math.Max(float64(maxX), float64(maxY)) + math.Min(float64(minX), float64(minY)) / 2.0
			} else {
				return math.Max(float64(maxX), float64(maxY))
			}
		} else if (maxX > minY) {
			high = pX - 1
		} else {
			low = pX + 1
		}
	}
	return -1.0;
}

func main() {
	arr1 := []int{1,2}
	arr2 := []int{3,4}
	fmt.Println(findMedianSortedArrays(arr1,  arr2))
}