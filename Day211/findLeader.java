package Day211;

import java.util.ArrayList;
import java.util.Collections;

public class findLeader {

    public static ArrayList<Integer> leader(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int max = arr[n-1];
        list.add(max);
        for (int i=n-2; i>=0; i--) {
            if (max <= arr[i]) {
                max = arr[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
    }
    
    public static void main(String[] args) {
        int arr[] = {6,17,4,3,5,2};
        int n = 6;
        System.out.println(leader(arr, n));
    }
}