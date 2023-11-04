package Day289;

public class lastMomentBeforeAllAntsFallOutOfAPlank{
    public static int getLastMoment(int n, int left[], int right[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer. MIN_VALUE;
        for (int i=0; i<left.length; i++) {
            max = Math.max(max, left[i]);
        }
        for (int i=0; i<right.length; i++) {
            min = Math.min(min, right[i]);
        }
        if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
            return Math.max(n-min, max);
        }
        return min == Integer.MAX_VALUE?max:n - min;
    }
    public static void main(String[] args) {
        int n1 = 4;
        int n2 = 7;
        int n3 = 7;
        int left1[] = {4,3};  
        int right1[] = {0,1};
        int left2[] = {};
        int right2[] = {0,1,2,3,4,5,6,7};
        int left3[] = {0,1,2,3,4,5,6,7};
        int right3[] = {};
        System.out.println(getLastMoment(n1, left1, right1));
        System.out.println(getLastMoment(n2, left2, right2));
        System.out.println(getLastMoment(n3, left3, right3));
    }
}