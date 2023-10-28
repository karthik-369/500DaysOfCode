func countVowelPermutation(n int) int {
	mod := 1000000007
   arr := [5]int{1,1,1,1,1}
   for i:=0; i<n-1; i++ {
	   temp := [5]int{0,0,0,0,0}
	   temp[0] = (arr[1]+arr[2]+arr[4])%mod
	   temp[1] = (arr[0] +arr[2]) %mod
	   temp[2] = (arr[1]+arr[3]) %mod
	   temp[3] = (arr[2])%mod
	   temp[4] = (arr[2]+arr[3])%mod
	   arr = temp
   }
   answer := 0;
   for _,v := range arr {
	   answer = (answer+v)%mod
   }
   return answer
}