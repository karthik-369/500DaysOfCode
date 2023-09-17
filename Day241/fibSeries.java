package Day241;

import java.util.Arrays;

public class fibSeries {
    
    public static long[] fib(int n) {
        long answer[] = new long[n];
        if (n>=1) {
            answer[0] = 1;
        }
        if (n>=2) {
            answer[1] = 1;
        }
        for (int i=3; i<=n; i++) {
            answer[i-1] = answer[i-3] + answer[i-2];
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(fib(n)));
    }
}