package Day240;

public class countNumberOfHops {

    public static long countHops(int n) {
        long a  = 1, b = 2, c = 4;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return b;
        }
        if (n == 3) {
            return c;
        }
        for (int i=4; i<=n; i++) {
            long d = ((a+b) %1000000007 + c) %1000000007;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countHops(n));
    }
}