class Solution {
    public int[] sortByBits(int[] arr) {
        int map[][] = new int[arr.length][2];
        for (int i=0; i<arr.length; i++) {
            int count = 0;
            int temp = arr[i];
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp >>= 1;
            }
            map[i][0] = arr[i];
            map[i][1] = count;
        }
        Arrays.sort(map, (a,b)->{
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } 
            return a[0] - b[0];
        });
        // for (int[] t: map) {
        //     System.out.println(Arrays.toString(t));
        // }
        for (int i=0; i<arr.length; i++) {
            arr[i] = map[i][0];
        }
        return arr;
    }
}