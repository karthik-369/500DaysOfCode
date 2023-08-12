package Day205;

import java.util.TreeSet;

public class lonIncSubSeq {

    public static int longestSub(int arr[]){
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<ts.last()){
                int temp = ts.ceiling(arr[i]);
                ts.remove(temp);
            }
            ts.add(arr[i]);
        }
        return ts.size();
    }

    public static void main(String[] args) {
        int arr[] = {6, 13, 7, 4, 8, 10};
        System.out.println(longestSub(arr));
    }
}