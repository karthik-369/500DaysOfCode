package Day277;

public class powerOfFour{
    public static boolean isPowerOfFour(int n) {
        return n!=0 && (n&(n-1)) == 0  &&  (n&0xAAAAAAAA) == 0;
    }
    public static void main(String[] args) {
        int n1 = 16;
        int n2 = 5;
        int n3 = 1;
        System.out.println(isPowerOfFour(n1));
        System.out.println(isPowerOfFour(n2));
        System.out.println(isPowerOfFour(n3));

    }
}