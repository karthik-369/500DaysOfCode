package Day242;

import java.util.Arrays;

class Pair {
    int rank, index;
    public Pair(int rank, int index) {
        this.rank = rank;
        this.index = index;
    }
}

public class TheKWeakestRowsInAMatrix {
    public static int[] kWeakestRow(int mat[][], int k) {
        int answer[] = new int[k];
        int n = mat.length;
        Pair arr[] = new Pair[n];
        for (int i=0; i<n; i++) {
            int rank = 0;
            for (int j=0; j<mat[i].length; j++) {
                rank += mat[i][j];
            }
            arr[i] = new Pair(rank, i);
        }

        Arrays.sort(arr, (a,b)->{
            if (a.rank == b.rank) {
                return a.index - b.index;
            }
            return a.rank - b.rank;
        });
        for (int i=0; i<k; i++) {
            answer[i] = arr[i].index;
        }
        return answer;
    }
    public static void main(String[] args) {
        int arr3[][] = {{1,0},{1,0},{1,0},{1,1}};
        int arr2[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int arr1[][] = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        System.out.println(Arrays.toString(kWeakestRow(arr1, 3)));
        System.out.println(Arrays.toString(kWeakestRow(arr1, 4)));
        System.out.println(Arrays.toString(kWeakestRow(arr2, 3)));
        System.out.println(Arrays.toString(kWeakestRow(arr3, 4)));
    }
}