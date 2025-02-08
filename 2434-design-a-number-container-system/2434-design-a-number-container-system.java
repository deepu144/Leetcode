class NumberContainers {
    HashMap<Integer,Integer> array;
    HashMap<Integer,PriorityQueue<Integer>> indexValues;
    public NumberContainers() {
        array=new HashMap<>();
        indexValues=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(array.containsKey(index)){
            int val=array.get(index);
            if(val==number) return;
            indexValues.get(val).remove(index);
        }
        indexValues.computeIfAbsent(number,k->new PriorityQueue<>()).offer(index);
        array.put(index,number);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> pq=indexValues.get(number);
        if(pq==null) return -1;
        if(pq.isEmpty()) return -1;
        return pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */