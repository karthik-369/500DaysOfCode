class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            int temp = columnNumber % 26;
            if (temp != 0) {
                sb.append((char)(temp-1+65));
            } else {
                sb.append((char)(65+25));
                columnNumber--;
            }
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}