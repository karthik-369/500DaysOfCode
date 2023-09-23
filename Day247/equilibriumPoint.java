package Day247;

public class equilibriumPoint {

    public static int equiPoint(int arr[], int n) {

        int ts = 0;
        for (int i=0; i<n; i++) {
            ts += arr[i];
        }
        int p = 0;
        for (int i=0; i<n; i++) {
            System.out.println(p + " " + (ts - (p+arr[i])));
            if (p == (ts - (p+arr[i]))) {
                return i+1;
            } else {
                p += arr[i];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,5,2,2};
        int n = 5;
        System.out.println(equiPoint(arr, n));
    }
}