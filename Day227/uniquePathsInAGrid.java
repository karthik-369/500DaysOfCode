package Day227;

public class uniquePathsInAGrid {
    public static int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int R = m - 1;
        long answer = 1;
        for (int i=1; i<=R; i++) {
            answer  = answer  * (N - R + i) /i;
        }
        return (int)answer;
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }
}