package Day343;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WildCardString {
    public static boolean match(String wild, String pattern) {
        wild=wild.replace("?",".+");
        wild=wild.replace("*", ".*");
        Pattern p = Pattern.compile(wild);
        Matcher m = p.matcher(pattern);
        return m.matches();

    }
    static boolean isalpha(char temp) {
        return ((temp >='a' && temp <='z')||(temp>='A'&&temp<='Z'));
            
    }
    static boolean match(String wild, String pattern)
    {
        // code here
        int i=0,j=0;
        int l1 = wild.length(), l2 = pattern.length();
        while(i<l1 && j<l2){
            if((isalpha(wild.charAt(i)) && isalpha(pattern.charAt(j))) && wild.charAt(i)!=pattern.charAt(j)){
                
                return false;
            }
            else if(wild.charAt(i)=='*'){
                if(i==l1-1) return true;
                if(wild.charAt(i+1)==pattern.charAt(j) && wild.charAt(i+1)!=pattern.charAt(j+1)){
                    i++;
                    continue;
                }
                i++;
                j++;
                
                if(wild.charAt(i)=='?' && wild.charAt(i+1)==pattern.charAt(j+1)){
                    i++;
                    j++;
                    continue;
                }
                while(j<l2 && wild.charAt(i)=='?' && wild.charAt(i+1)!=pattern.charAt(j+1) && isalpha(wild.charAt(i+1))){
                    j++;
                }
                while(wild.charAt(i)=='*'){
                    i++;
                    j++;
                }
                while(isalpha(wild.charAt(i)) && j<l2 && wild.charAt(i)!=pattern.charAt(j)){
                    j++;
                }
                if(j==l2) {
                    return false;
                }
            }
            i++;
            j++;
            
        }
        while(i<l1){
            if(isalpha(wild.charAt(i))) return false;
            i++;
        }
        if(j<l2){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String wild1 = "ge*ks";
        String pattern1 = "geeks";
        String wild2 = "ge?ks*";
        String pattern2 = "geeksforgeeks";
        System.out.println(match(wild1, pattern1));
        System.out.println(match(wild2, pattern2));
    }
}