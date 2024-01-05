//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first= first;
        this.second = second;
    }
}
class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a,b)->a.first - b.first);
        for (int i=0 ;i<n; i++) {
            priorityQueue.add(new Pair(price[i], i+1));
        }
        int answer = 0;
        int sum = 0;
        boolean flag = false;
        while (priorityQueue.size() > 0) {
            Pair temp = priorityQueue.poll();
            for (int i=temp.second; i>=1; i--) {
                sum += (temp.first * i);
                if (sum <= k) {
                    answer += i;
                    break;
                } else {
                    flag = true;
                    sum -= (temp.first * i);
                }
            }
            if (flag) {
                break;
            }
            
         }
         return answer;
    }
}
        
    