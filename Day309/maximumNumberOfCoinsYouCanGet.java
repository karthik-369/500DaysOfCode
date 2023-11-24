package Day309;

import java.util.PriorityQueue;

public class maximumNumberOfCoinsYouCanGet {
    public static int maxCoins(int piles[]) {
        int answer = 0;
        int arr[] = new int[100001];
        for (int i=0; i<piles.length; i++) {
            arr[piles[i]]++;
        }
        int k = piles.length/3;
        boolean flag = true;
        int i = arr.length-1;
        while (k != 0) {
            if (arr[i] > 0) {
                if (flag) {
                    flag = false;
                } else {
                    answer += i;
                    flag = true;
                    k--;
                }
                arr[i]--;
            } else {
                i--;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int piles1[] = {2,4,1,2,7,8};
        int piles2[] = {2,4,5};
        int piles3[] = {9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins(piles1));	
        System.out.println(maxCoins(piles2));
        System.out.println(maxCoins(piles3));
    }
}