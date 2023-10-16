package Day270;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> answer = new ArrayList<>();
        int temp = 1;
        answer.add(temp);
        for (int i=1; i<= rowIndex; i++) {
            int num = (temp * (rowIndex - i + 1))/ i;
            answer.add(num);
            temp = num;
        }
        
        return answer;
    } 
    public static void main(String[] args) {
        int rowIndex1 = 3;
        int rowIndex2 = 0;
        int rowIndex3 = 1;
        System.out.println(getRow(rowIndex1));
        System.out.println(getRow(rowIndex2));
        System.out.println(getRow(rowIndex3));
    }
}