package Day202;

public class largePrimeFactor{
    public static void main(String[] args){
        int n = 5;
        System.out.println(largestPrimeFactor(n));
    }
    // public static boolean isPrime(int n){
    //     for(int i=2;i*i<=n;i++){
    //         if(n%i==0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    static long largestPrimeFactor(int N) {
        // code here
        int i =2;
        int answer = -1;
        while(i*i<=N){
            while(N%i==0){
                answer = i;
                N/=i;
            }
            i+=1;
        }
        if(N>1){
            answer = N;
        }
        return answer;
    }
}