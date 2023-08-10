package main

import "fmt"

func longestSubString(x int, y int,  s1 string,  s2 string)(int ){
	arr:= make([][]int, x+1)
	for i:=0;i<=x;i++{
		arr[i] = make([]int, y+1)
	}
	for i:=0;i<=x;i++{
		for j:=0;j<=y;j++{
			if i==0 || j==0{
				arr[i][j] = 0
			}else if(s1[i-1]==s2[j-1]){
				arr[i][j] = arr[i-1][j-1]+1
			}else{
				arr[i][j] = max(arr[i-1][j], arr[i][j-1])
			}
		}
	}
	return arr[x][y]
}


func main(){
	s1:="ABCDGH"
	s2:= "AEDFHR"
	x:=6
	y:=6
	fmt.Println(longestSubString(x,y, s1,s2))

}