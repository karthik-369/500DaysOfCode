package Day332;

class Pair{
    String first, second;
    int third;
    public Pair(String first, String second, int third) {
        this.first= first;
        this.second = second;
        this.third = third;
    }
}
class FoodRatings {
    Map<String, PriorityQueue<Pair>> cmap;
    Map<String, Pair> fmap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cmap = new HashMap<>();
        fmap = new HashMap<>();
        for (int i=0; i<foods.length; i++) {
            Pair temp = new Pair(foods[i], cuisines[i], ratings[i]);
            fmap.put(foods[i], temp);
            if (cmap.containsKey(cuisines[i])) {
                cmap.get(cuisines[i]).add(temp);
            } else {
                PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(new Comparator<Pair>() {
                    @Override 
                    public int compare(Pair a, Pair b) {
                        int t = b.third - a.third;
                        if (t == 0) {
                            return (a.first).compareTo(b.first);
                        }
                        return t;
                    } 
                });
                priorityQueue.add(temp);
                cmap.put(cuisines[i], priorityQueue);
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        Pair temp = fmap.get(food);
        Pair temp2 = new Pair(food, temp.second, newRating);
        fmap.put(food, temp2);
        temp.first="";
        cmap.get(temp.second).add(temp2);
    }
    
    public String highestRated(String cuisine) {
        while (cmap.get(cuisine).peek().first.equals("")) {
            cmap.get(cuisine).remove();
        }
        return cmap.get(cuisine).peek().first;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
