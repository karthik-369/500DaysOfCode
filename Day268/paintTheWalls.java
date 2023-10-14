package Day268;

public class paintTheWalls {

    
    static int arr[][];
    public static int paintWalls(int[] cost, int[] time) {
        int l = cost.length;
        arr = new int[l][l];
        return dfs(0, cost, time, 0);
    }
    public static int dfs(int i, int cost[], int time[], int count)  {
        if (count >= cost.length) {
            return 0;
        }
        if (i>=cost.length) {
            return 1000000;
        }
        if (arr[i][count] !=0) {
            return arr[i][count];
        }
        int a = dfs(i+1, cost, time, count);
        int b = cost[i] + dfs(i+1, cost, time, count+time[i]+1);
        return arr[i][count] = Math.min(a, b);
    }


    public static void main(String[] args) {
        int cost1[] = {1,2,3,2};
        int time1[] = {1,2,3,2};
        int cost2[] = {2,3,4,2};
        int time2[] = {1,1,1,1};
        int cost3[] = {26,53,10,24,25,20,63,51};
        int time3[] = {1,1,1,1,2,2,2,};
        System.out.println(paintWalls(cost1, time1));
        System.out.println(paintWalls(cost2, time2));
        System.out.println(paintWalls(cost3, time3));
    }
}