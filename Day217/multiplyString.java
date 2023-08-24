package Day217;
//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.newFunc(a,b));
            System.out.println(g.afunc(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        long num1 = 0, num2 = 0;
        long mul = 0;
        boolean f1=false, f2=false;
        for (int i=s1.length()-1; i>=0; i--) {
            if (s1.charAt(i)>='0' && s1.charAt(i)<='9') {
                if (mul == 0) {
                    num1 = ((s1.charAt(i) - '0'));
                    mul = 1;
                } else {
                    mul *= 10;
                    num1 += (((s1.charAt(i)) - '0')*mul);
                }    
            } else {
                f1 = true;
            } 
            
        }
        // System.out.println(num1);
        mul = 0;
        for (int i=s2.length()-1; i>=0; i--) {
            if (s2.charAt(i)>='0' && s2.charAt(i)<='9'){
                    if (mul == 0) {
                    num2 = ((s2.charAt(i) - '0'));
                    mul = 1;
                } else {
                    mul *= 10;
                    num2 += (((s2.charAt(i)) - '0')*mul);
                }    
            } else {
                f2 = true;
            }
            
        }
        // System.out.println(num2);
        long answer = num1 * num2;
        // System.out.println(answer);
        StringBuilder sb = new StringBuilder();
        while(answer != 0) {
            char temp = (char)((answer%10)+48);
            sb.append(temp);
            answer/=10;
        }
        if (f1 ^ f2) {
            // System.out.println("from xor");
            sb.append('-');
        }
        return sb.reverse().toString();
    }


    public String newFunc(String s1, String s2) {
        
        int l1 = s1.length(), l2 = s2.length();
        int answer[] = new int[l1 + l2]; 
        
        for (int i=l1-1; i>=0; i--) {
            if (s1.charAt(i) == '-') {
                continue;
            }
            char low = s1.charAt(i);
            int carryPerIt = 0, carryRes = 0;
            int pos = l1 - 1 - i;
            for (int j=l2-1; j>=0; j--) {
                char up = s2.charAt(j);
                if (up == '-') {
                    continue;
                }
                int newR = ((low-'0') * (up-'0')) + carryPerIt;
                int r = newR % 10;
                carryPerIt = newR / 10;
                int temp = answer[pos] + r + carryRes;
                answer[pos] = temp % 10;
                carryRes = temp / 10;
                pos++;
            }
            answer[pos] = answer[pos] + carryPerIt + carryRes;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i=answer.length-1; i>=0; i--) {
            if (answer[i] != 0 || flag) {
                sb.append(answer[i]);
                flag = true;
            }
        }
        System.out.println(Arrays.toString(answer));
        if (s1.charAt(0) == '-' ^ s2.charAt(0) == '-') {
            return '-'+sb.toString();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public String afunc(String s1, String s2) {
        BigInteger bg = new BigInteger(s1);
        BigInteger tg = new BigInteger(s2);
        return bg.multiply(tg).toString();
    }
}