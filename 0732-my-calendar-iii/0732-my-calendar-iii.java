class MyCalendarThree {
    Map<Integer,Integer> map;
    public MyCalendarThree() {
        map=new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int count=0,max=-1;
        for(int book : map.values()){
            count+=book;
            max=Math.max(max,count);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */