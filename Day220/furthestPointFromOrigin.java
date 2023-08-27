package Day220;
class FurthestDistanceFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int count = 0, lc = 0, rc = 0;
        for (int i=0; i<moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                lc++;
            }
            if (moves.charAt(i) == 'R') {
                rc++;
            }
            if (moves.charAt(i) == '_') {
                count++;
            }
        }
        return count +(Math.max(lc, rc) - Math.min(lc,rc));
    }
}