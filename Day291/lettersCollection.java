

//User function Template for Java

class Solution{
    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
    {
        // code here
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<q; i++) {
            answer.add(find(queries[i][1], queries[i][2], n, m, mat, queries[i][0]));
            
        }
        return answer;
    }
    public static int find(int i, int j, int n, int m, int mat[][], int k) {
        int sum  =0;
        for (int t = i-k;t<=i+k;t++) {
            if (j>=k && t>=0 && t<n) {
                sum += mat[t][j-k];
            }
        }
        for (int t = i-k;t<=i+k;t++) {
            if (j+k<m && t>=0 && t<n) {
                sum += mat[t][j+k];
            }
        }
        for (int t = j-k+1;t<=j+k-1;t++) {
            if (i>=k && t>=0 && t<m) {
                sum += mat[i-k][t];
            }
        }
        for (int t = j-k+1;t<=j+k-1;t++) {
            if (i+k<n && t>=0 && t<m) {
                sum += mat[i+k][t];
            }
        }
        return sum;
    }
}