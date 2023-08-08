package Day201;

import java.util.HashMap;
import java.util.Map;

public class fractionPair{
    public static void main(String[] args){
        int n = 4;
        int num[] = {1,2,2,8};
        int denn[] = {2,4,6,12};
        System.out.println(countPair(n, num, denn));
    }
    public static int countPair(int n, int num[], int denn[]){
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int g = gcd(num[i], denn[i]);
            String temp = (num[i]/g)+"?"+(denn[i]/g);
            String diff = (denn[i]/g - num[i]/g)+"?"+(denn[i]/g);
            if(map.containsKey(diff)){
                answer+= map.get(diff);
            }
            map.put(temp, map.getOrDefault(temp,0)+1);
        }
        return answer;
    }
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
