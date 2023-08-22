func convertToTitle(columnNumber int) string {
    var str string
    for columnNumber != 0 {
        temp := columnNumber % 26
        if temp != 0 {
            str = string(byte(65+temp - 1)) + str
        } else {
            str = string(byte(65 + 25)) + str
            columnNumber--
        }
        columnNumber /= 26
    }
    return str
}

// func reverse(str string) string {
//     var result string
//     for _, v := range str {
//         result = string(v) + result
//     }
//     return result
// }