package Day277;

public class maxSumIncSubSeq {
    public static int maxSumInc(int n, int arr[]) {
        int answer = 0;
        int dp[] = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = arr[i];
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 4;
        int num1[] = {1, 101, 2, 3, 100};
        int num2[] = {4, 1, 2, 3};
        System.out.println(maxSumInc(n1, num1));
        System.out.println(maxSumInc(n2, num2));
    }
}