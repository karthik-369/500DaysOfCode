class Solution {
    public double soup(int i, int j, Double[][] arr){
        if(i<=0 && j<=0){
            return 0.5;
        }
        if(i<=0){
            return 1;
        }
        if(j<=0){
            return 0;
        }
        if(arr[i][j]!=null){
            return arr[i][j];
        }
        arr[i][j] = 0.25 * (soup(i-100, j, arr)+soup(i-75, j-25, arr) +soup(i-50, j-50, arr)+soup(i-25, j-75, arr));
        return arr[i][j];
    }
    public double soupServings(int n) {
        if(n>=5000){
            return 1.0;
        }
        return soup(n, n , new Double[n+1][n+1]);
    }
}