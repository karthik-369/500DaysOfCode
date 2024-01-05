class Solution {
    public int[][] imageSmoother(int[][] img) {
        int dir[][] ={{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,0}, {0,1}, {1,-1},{1,1}, {1,0}};
        int answer[][] = new int[img.length][img[0].length];
        for (int i=0; i<img.length; i++) {
            for ( int j=0; j<img[0].length; j++) {
                int temp = 0;
                int count = 0;
                for (int v[] :  dir ){
                    int x = i + v[0];
                    int y =  j+v[1];
                    if (x>=0 && y>=0 && x<img.length && y<img[0].length) {
                        temp += img[x][y];
                        count++;
                    }
                }
                answer[i][j] = temp/count;
            }
        }
            return answer;
    }
}