// leetcode 146

class LRUCache {
    public int capacity;
    public Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int temp = map.get(key);
            map.remove(key);
            map.put(key, temp);
            return temp;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.size()>=capacity && !map.containsKey(key)){
            map.remove(map.entrySet().iterator().next().getKey());
        }
        if(map.containsKey(key)){
            map.remove(key);
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */