package Day207;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//User function Template for Java

public class NonRepeatingNumbers
{
    public static int[] singleNumber(int[] nums)
    {
        // Code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }
        int size = 0;
        int answer[] = new int[2];
        for(int key: map.keySet()) {
            if(map.get(key)==1) {
                answer[size++] = key;
            }
        }
        if(answer[0]>answer[1]){
            answer[0] = answer[0] ^ answer[1];
            answer[1] = answer[1] ^ answer[0];
            answer[0] = answer[0] ^ answer[1];
        }
        return answer;
    }
    public static void main(String[] args) {
        int arr[] = {18 ,24 ,24 ,21 ,10 ,29, 8 ,10 ,29 ,18};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }
}