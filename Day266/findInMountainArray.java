package Day266;

class findInMountainArray {

    public static int lSearch (int[] arr, int target,int low, int high) {
        while (low <= high) {
            int mid = high - ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                low  = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int rSearch (int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = high - ((high - low) >> 1); 
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                low = mid + 1;
            }
             else {
                high = mid -1;
             }

        }
        return -1;
    }

    public static int find(int arr[]) {
        int l =0, h = arr.length - 1;
        while ( l<h) {
            int mid =  l + (h - l )/2;
            if (arr[mid] < arr[mid+1]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    public static int fImMArray(int[] arr, int target) {

        int max = find(arr);

        int test = lSearch(arr, target , 0, max);
        return test == -1? rSearch(arr, target, max+1, arr.length -1): test;
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,3,1};
        int target1 = 3;
        int arr2[] = {0,1,2,4,2,1};
        int target2 = 3;
        int arr3[] = {3};
        int target3 = 3;
        int arr4[] = {1, 2, 3, 5, 3};
        int target4 = 0;
        System.out.println(fImMArray(arr1, target1));
        System.out.println(fImMArray(arr2, target2));
        System.out.println(fImMArray(arr3, target3));
        System.out.println(fImMArray(arr4, target4));
    }
}