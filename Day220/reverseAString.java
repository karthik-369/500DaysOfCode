package Day220;
public class reverseAString{
    public static String reverseWord(String str)
    {
        // Reverse the string str
        int low = 0;
        int high = str.length()-1;
        char arr[] = str.toCharArray();
        while (low <= high) {
            char temp = arr[low];
            arr[low]= arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return new String(arr);
    }
}