package Day234;

public class countAllValidPickupAndDelivery {
    public static int mod = 1000000007;
    private static final int MOD = 1000000007;

    public static int fact(int n) {
        int answer = 1;
        for (int i = n; i > 0; i--) {
            answer = (int) ((answer * (long) i) % MOD);
        }
        return answer;
    }

    public static int countOrders(int n) {
        int odd = 1;
        int temp = 1;
        for (int i = 0; i < n; i++) {
            odd = (int) ((odd * (long) temp) % MOD);
            temp = (temp + 2) % MOD;
        }
        odd = (int) ((odd * (long) fact(n)) % MOD);
        return odd;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(countOrders(n));
    }
}