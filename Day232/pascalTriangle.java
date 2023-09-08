class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                int prevVal1 = r.get(i - 1).get(j - 1);
                int prevVal2 = r.get(i - 1).get(j);
                row.add(prevVal1 + prevVal2);
            }

            if (i > 0) {
                row.add(1);
            }

            r.add(row);
        }

        return r;
    }
}
