func getWinner(arr []int, k int) int {
    win := arr[0]
    temp := 0 
    for i:=1; i<len(arr); i++ {
        if win > arr[i] {
            temp ++
        } else {
            temp = 1
            win = arr[i]
        }
        if temp == k {
            return win
        }
    }
    return win
}