class LRUCache {
    Map<Integer,Integer> map;
    Deque<Integer> deque;
    int size;
    public LRUCache(int capacity) {
        size=capacity;
        deque=new ArrayDeque<>();
        map=new HashMap<>();
    }
    
    public int get(int key) {
        int value=map.getOrDefault(key,-1);
        if(value==-1) return value;
        deque.remove(key);
        deque.offerLast(key);
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            deque.remove(key);
            deque.offerLast(key);
        }else{
            if(deque.size()==size) map.remove(deque.pollFirst());
            map.put(key,value);
            deque.offerLast(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */