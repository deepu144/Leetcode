class RandomizedSet {
    List<Integer> list;
    HashMap<Integer,Integer> map;
    Random random;
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
        random=new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index=map.get(val);
        int lastElement=list.getLast();
        list.set(index,lastElement);
        map.put(lastElement,index);
        list.removeLast();
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index=random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */