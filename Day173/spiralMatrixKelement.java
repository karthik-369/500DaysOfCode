
class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	// Your code here	
    	int sr = 0, sc = 0;
    	int er = n-1;
    	int ec = m-1;

    	int count =0;
	    while(count<k){
	        for(int i=sc;i<=ec && count<k;i++){
	            if(count == k-1){
	                return A[sr][i];
	            }
	            count++;
	        }
	        sr++;
	        for(int i=sr;i<=er && count<k;i++){
	            if(count==k-1){
	                return A[i][ec];
	            }
	            count++;
	        }
	        ec--;
	        for(int i=ec;i>=sc && count<k;i--){
	            if(count==k-1){
	                return A[er][i];
	            }
	            count++;
	        }
	        er--;
	        for(int i=er;i>=sr && count<k;i--){
	            if(count ==k-1){
	                return A[i][sc];
	            }
	            count++;
	        }
	        sc++;
	    }
	    return -1;
    }
}