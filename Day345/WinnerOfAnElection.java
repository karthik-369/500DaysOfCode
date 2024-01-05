//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        Map<String, Integer> map = new TreeMap<>();
        for (int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
        }
        int temp = 0;
        String answer = "";
        for (String key : map.keySet()) {
            if (answer.equals("")) {
                answer = key;
                temp = map.get(key);
            }
            else if (temp == map.get(key)) {
                if (key.compareTo(answer)<0) {
                    answer = key;
                }
            }
            else if (temp < map.get(key)) {
                temp = map.get(key);
                answer = key;
            } 
        }
        return new String[]{answer, String.valueOf(temp)};
    }
}

