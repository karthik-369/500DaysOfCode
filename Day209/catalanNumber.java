package Day209;

public class catalanNumber {
    public static int mod = 1000000007;
    public static int catalan(int n) {
        // int answer =  ncr(2*n, n)/(n+1);
        // int fact = ncr(2*n, n);
        // System.out.println(fact);
        // System.out.println(ncr(5,3));
        // System.out.println(answer);
        // int answer = ncir(2*n, n)/(n+1);
        // System.out.println(ncir(2*n, n));
        // System.out.println(ncr(2*n, n));
        

        // other methods result in TLE or Integer overflow
        // dp
        if (n <= 1) {
            return 1;
        } 
        int arr[] = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<=n; i++){
            arr[i] = 0;
            for(int j=0; j<i; j++) {
                arr[i] = (int)((arr[i] + (long)arr[j] * arr[i - j -1])%mod) %mod;
            }
        }
        return arr[n];

    }
    //recursion leads to TLE
    public static int ncr(int n, int r) {
        if(r == 0 || n == r) {
            return 1;
        }
        return ncr(n-1, r-1) + ncr(n-1, r);
    }
    //iterative try
    public static int  fact(int n) {
        int answer = 1;
        for(int i=1;i<=n;i++) {
            answer = (answer * i)%mod;
        }
        return answer;
    }
    public static int ncir(int n ,int r) {
        int  a = fact(n);
        System.out.println(a);
        
        int b = fact(r);
        System.out.println(b);
        int c = fact(n-r);
        System.out.println(b*c);
        double temp= ((double)1/b*(double)1/c)%mod;
        System.out.println(temp);
        return (int)(temp/((double)1/a)%mod)%mod;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(catalan(n));
    }
}