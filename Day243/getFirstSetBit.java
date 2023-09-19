package Day243;

public class getFirstSetBit {

    public static int findFirstSetBit(int n) {
        if (n == 0) {
            return 0;
        }
        int answer = 1;
        while (n!=0) {
            if ((n&1)==0) {
                answer++;
                n >>= 1;
            } else {
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(findFirstSetBit(n));
    }
}