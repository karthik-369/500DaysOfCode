class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = prices[0], min2 = Integer.MAX_VALUE;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < min1) {
                min2= min1;
                min1 = prices[i];
            } else if (min2 > prices[i]) {
                    min2 = prices[i];
            }
        }
        // fmt.Println(min1, min2)
        if ((min1 + min2) <= money) {
            return money - min1 - min2;
        }
        return money;
    }
}