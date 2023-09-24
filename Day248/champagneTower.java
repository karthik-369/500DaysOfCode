package Day248;


import java.util.ArrayList;
import java.util.List;

public class champagneTower {

    public static double tower(int poured, int query_row, int query_glass) {
        // List<List<Double>> list = new ArrayList<>();
        if (poured ==  0 ){
            return 0;
        }
        List<Double> list = new ArrayList<>();
        list.add( new Double(poured));
        while (query_row-- > 0) {
            List<Double> temp = new ArrayList<>();
            temp.add(Math.max((list.get(0)-1)/2, 0));
            for (int i=1; i<list.size(); i++) {
                temp.add(Math.max((list.get(i-1)-1)/2, 0) + Math.max((list.get(i)-1)/2, 0));
            }
            temp.add(temp.get(0));
            list = new ArrayList<>(temp);
        }
        return Math.min(1, list.get(query_glass));
    }

    public static void main(String[] args) {
        int poured = 2;
        int query_row = 1;
        int query_glass = 1;
        System.out.println(tower(poured, query_row, query_glass));
    }
}