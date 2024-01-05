//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] nm = IntArray.input(br, 2);
            
            
            int[][] a = IntMatrix.input(br, nm[0], nm[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.sumZeroMatrix(a);
            
            if(res.size() == 0) {
                System.out.println(-1);
                
            } else {
            
                IntMatrix.print(res);
            }        
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int s = 0, e = 0;
    public static int  maxL(int a[]) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<a.length; i++) {
            sum += a[i];
            if (a[i] == 0 && max == 0) {
                s = i;
                e = i;
                max =1;
            }
            if (sum == 0) {
                if (max < i + 1) {
                    s = 0;
                    e = i;
                }
                max = i+1;
            }
            if (map.containsKey(sum))  {
                int temp = max;
                max = Math.max(max, i-map.get(sum));
                if (max > temp) {
                    e = i;
                    s = map.get(sum) + 1;
                }
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        // code here
        int r = a.length, c = a[0].length;
        int sc = 0, ec = 0, sr = 0, er = 0, max = Integer.MIN_VALUE;
        for (int i=0; i<c; i++) {
            int temp[] = new int[r];
            for (int j=i; j<c;j++) {
                for(int k=0; k<r; k++) {
                    temp[k] += a[k][j];
                }
                int len = maxL(temp);
                int area = (e-s+1) * (j-i+1);
                if (len > 0 && area > max) {
                    sr = s;
                    er =  e;
                    sc = i;
                    ec = j;
                    max = area;
                }
            }
        }
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for (int i=sr; i<=er; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j=sc; j<=ec; j++) {
                temp.add(a[i][j]);
            }
            answer.add(temp);
        }
        return answer;
    }
}
        
