class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    public MedianFinder() {
        small=new PriorityQueue<>((a,b)->b-a);
        large=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        if(!small.isEmpty() && !large.isEmpty() && small.peek()>large.peek()) large.offer(small.poll());
        if(small.size()>large.size()+1) large.offer(small.poll());
        else if(small.size()<large.size()) small.offer(large.poll());
    }
    
    public double findMedian() {
        if(small.size()>large.size()) return small.peek();
        return (small.peek()+large.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */