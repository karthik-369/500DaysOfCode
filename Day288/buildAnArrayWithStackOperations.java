class Solution {
    public List<String> buildArray(int[] target, int n) {
        int s = 1;
        List<String> answer = new ArrayList<>();
        for (int v : target) {
            while (s < v) {
                answer.add( "Push");
                answer.add( "Pop");
                s++;
            }
            s++;
            answer.add( "Push");
        }
        return answer;
    }
}