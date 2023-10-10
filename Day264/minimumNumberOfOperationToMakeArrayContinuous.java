package Day264;

import java.util.Arrays;

public class minimumNumberOfOperationToMakeArrayContinuous {
    
      public static int minimumOperation(int arr[]) {
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        int j = 1, temp = 0;
        int tempArr[] = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            while (j<arr.length && arr[j] < arr[i] + arr.length-1) {
                if (arr[j] == arr[j-1]) {
                    temp++;

                }
                tempArr[j] = temp;
                temp++;
            }
            answer = Math.min(answer, i+(arr.length-j)+temp-tempArr[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr1[] = {4,2,5,3};
        int arr2[] = {1,2,3,4,5,6};
        int arr3[] = {1,10,100,1000};
        System.out.println(minimumOperation(arr1));
        System.out.println(minimumOperation(arr2));
        System.out.println(minimumOperation(arr3));
    }
}