class Solution {
    public int findA(int mat[][], int i) {
        int temp = -1;
        for (int j=0; j<mat[0].length; j++) {
            if (mat[i][j] == 1) {
                if (temp >=0) {
                    return -1;
                } else {
                    temp = j;
                }
            }
        }
        return temp;
    }
    public boolean findB(int mat[][], int i, int ind) {
        for (int j=0; j<mat.length; j++) {
            if (mat[j][ind] == 1 && j != i) {
                return false;
            }
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        int answer = 0;
        for (int i=0 ;i<mat.length; i++) {
            int temp = findA(mat, i);
            if (temp >=0 && findB(mat, i, temp)) {
                answer++;
            }
        }
        return answer;
    }
}