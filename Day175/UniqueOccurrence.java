

class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(int key: map.keySet()){
            if(set.contains(map.get(key))){
                return false;
            }
            set.add(map.get(key));
        }
        return true;
    }
}
        
