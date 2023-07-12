class Solution
{
        
    long power(int N,int R)
    {
       long mod = 1000000007;
       if(R==1){
           return N%mod;
       }
       long answer = power(N,R/2);
       answer = (answer*answer)%mod;
       if(R%2==1){
           answer = (answer*N)%mod;
       }
       return answer;
    }

}