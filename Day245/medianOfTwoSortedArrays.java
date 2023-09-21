package Day245;

public class medianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if (x >  y) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = x;

        while (low <= high) {
            int px = high - ((high-low)>>1);
            int py = (x+y + 1) / 2 - px;
            int mx = (px == 0) ? Integer.MIN_VALUE:nums1[px-1];
            int my = (py == 0) ? Integer.MIN_VALUE:nums2[py-1];
            int minX = (px == x) ? Integer.MAX_VALUE: nums1[px];
            int minY = (py == y) ? Integer.MAX_VALUE: nums2[py];
            if (mx <= minY && my <= minX) {
                if ((x+y)%2 == 0) {
                    return ((double)(Math.max(mx, my)+Math.min(minX, minY)))/2.0;
                } else {
                     return (double)Math.max(mx, my);
                } 
            } else if (mx > minY) {
                high = px -1;
            } else {
                low = px+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr1[] = {1,3};
        int arr2[] = {2,3,6,8,9};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}