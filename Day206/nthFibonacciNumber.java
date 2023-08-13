package Day206;

public class nthFibonacciNumber {

    public static int fib(int num){
        if (num == 1 || num == 2 ){
            return 1;
        }

        int a = 1;
        int b = 1;
        int c = 0;
        for(int i=2;i<num;i++) {
            c = (a+b) % 1000000007;
            a = b;
            b = c;
        }   
        return c% 1000000007;
    }

    public static void main(String[] args) {
        int num = 1000;
        System.out.println(fib(num));
    }
}