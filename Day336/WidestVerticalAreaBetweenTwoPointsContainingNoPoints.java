class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0]-b[0];
        });
        int answer = Integer.MIN_VALUE;
        for (int i=1; i<points.length; i++) {
            answer = Math.max(answer, points[i][0] - points[i-1][0]);
        }
        return answer;
    }
}