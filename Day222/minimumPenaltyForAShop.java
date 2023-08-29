class minimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        int len = customers.length();
        int y[] = new int[len+1], n[] = new int[len+1];
        int prey = 0, pren = 0;
        for (int i=0; i<len; i++) {
            if (customers.charAt(i) == 'Y') {
                prey++;
            } else {
                pren++;
            }
            y[i+1] = prey;
            n[i+1] = pren;
        }
        //
        //penality = totalYcus - no of yes cus + no of no cus (for the respective index)
        int answer = 0;
        // System.out.println(Arrays.toString(y));
        // System.out.println(Arrays.toString(n));
        for (int i=1; i<=len; i++) {
            if (prey - y[answer]  + n[answer] > prey - y[i] + n[i]) {
                answer = i;
            }
        }
        return answer;
    }
}