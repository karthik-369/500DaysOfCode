package Day244;

import java.util.List;
import java.util.ArrayList;

public class rotateBits {

    public static List<Integer> rotate(int n, int d) {
        List<Integer> list = new ArrayList<>();
        d = d % 16;
        System.out.println((n<<d) + " "+(n>>(16-d))+" "+ (Math.pow(2,16) -1) );
        System.out.println((n<<d) | (n>>(16-d)));
        System.out.println((n>>d) + " "+(n<<(16-d))+" "+ (Math.pow(2,16) -1) );
        System.out.println((n>>d) | (n<<(16-d)));
        int a = ((n<<d) | (n>>(16-d)) & (int)Math.pow(2, 16)-1);
        int b = ((n>>d) | (n<<(16-d)) & (int)Math.pow(2, 16)-1);
        list.add(a);
        list.add(b);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(rotate(18, 2));
        System.out.println(rotate(8, 2));
        System.out.println(rotate(2, 3));
        System.out.println(rotate(28, 2));
    }
}