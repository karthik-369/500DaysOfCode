class Solution {
    public boolean isPathCrossing(String path) {
         Set<Pair<Integer, Integer>> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(new Pair<>(x, y));

        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'S') {
                y -= 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'W') {
                x -= 1;
            }

            if (set.contains(new Pair<>(x, y))) {
                return true;
            }

            set.add(new Pair<>(x, y));
        }

        return false;
    }
}