class Solution {
    public String clearStars(String s) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(s.charAt(a)==s.charAt(b)) return b-a;
            return s.charAt(a)-s.charAt(b);
        });
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        boolean[] isRemoved = new boolean[n];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='*') isRemoved[pq.poll()]=isRemoved[i]=true;
            else pq.offer(i);
        } 
        for(int i=0;i<n;i++){
            if(!isRemoved[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}