package Day285;

import java.util.Arrays;

class findTheOriginalArrayOfPrefixXOR {
    public static int[] findArray(int pref[]) {
        for (int i= pref.length- 1; i>0; i--) {
            pref[i] ^= pref[i-1];
        }
        return pref;
    }
    public static void main(String[] args) {
        int arr1[] = {5,2,0,3,1};
        int arr2[] = {13};
        System.out.println(Arrays.toString(findArray(arr1)));
        System.out.println(Arrays.toString(findArray(arr2)));
    }
}