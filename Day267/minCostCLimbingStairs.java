public class minCostCLimbingStairs {
    public static int minCostClimbingStairs(int cost[]) {
        int answer[] = new int[cost.length+1];
        answer[cost.length-1] = cost[cost.length-1];
        answer[cost.length-2] = cost[cost.length-2]; 
        for (int i=cost.length-3; i>=0; i--) {
            answer[i] = cost[i] + Math.min(answer[i+1], answer[i+2]);
        }
        // System.out.println(Arrays.toString(answer));
        return Math.min(answer[0], answer[1]);
    }
    public static void main(String[] args) {
        int arr1[] = {10, 15, 20};
        int arr2[] = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(arr1));
        System.out.println(minCostClimbingStairs(arr2)); 
    }
}
