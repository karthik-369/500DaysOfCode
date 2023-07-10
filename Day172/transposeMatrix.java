
class Solution
{
    public void transpose(int n,int arr[][])
    {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && j<=i){
                    arr[i][j] = arr[i][j] ^ arr[j][i];
                    arr[j][i] = arr[j][i] ^ arr[i][j];
                    arr[i][j] = arr[i][j] ^ arr[j][i];
                }
            }
        }
    }
} 
    
