func findSpecialInteger(arr []int) int {
    count := len(arr)/4
    for i:=0; i<len(arr)-count; i++ {
        if arr[i] == arr[i+count] {
            return arr[i]
        }
    }
return -1
}