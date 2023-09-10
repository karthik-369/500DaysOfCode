package main
import (
	"fmt"
)
func fact(n int) int {
    answer:= 1
    for i:=n; i>0; i-- {
        answer  = (answer*i) %1000000007;
    }
    return answer
}
func countOrders(n int) int {
    odd := 1
    temp := 1
    for i:=0; i<n; i++{
        odd = (odd * temp)%1000000007;
        temp = (temp + 2)%1000000007;
    }
    odd = (odd * fact(n))%1000000007;
    return odd
}

func main() {
	n := 8
	fmt.Println(countOrders(n))
}