package Day242;

public class powerOfTwo {

    public static int powerFunk(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        while (n != 1) {
            if (n % 2 == 1) {
                return 0;
            }
            n /= 2;
        }
        return 1;
    }

    public static boolean isPowerOfTwo(int n) {
        if (powerFunk(n) == 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 1024;
        System.out.println(isPowerOfTwo(n));
    }
}