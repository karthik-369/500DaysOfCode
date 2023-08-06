package Day199;
import java.util.Arrays;
class numberOfMusicPlaylists{
    public static void main(String[] args){
        int n = 3;
        int goal = 3;
        int k = 1;
        System.out.println(numMusicPlaylists(n, goal, k));
    }

    public static int numMusicPlaylists(int n, int goal, int k){
        int mod = 1000000007;
        long arr[] = new long[goal - n  + 1];
        Arrays.fill(arr, 1);
        for(int i=2;i<=n-k;i++){
            for(int j=1;j<=goal-n;j++){
                arr[j]+=arr[j-1]*i;
                arr[j] %= mod;
            }
        }
        long answer = arr[goal-n];
        for(int i=2;i<=n;i++){
                answer = answer  * i %mod;
        }
        return (int)answer;
    }
}
