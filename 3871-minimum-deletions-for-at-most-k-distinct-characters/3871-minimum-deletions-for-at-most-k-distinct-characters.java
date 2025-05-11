class Solution {
    public int minDeletion(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length(),remove=0,res=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        remove=map.size()-k;
        if(remove<=0) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(map.values());
        while(remove-->0){
            if(!pq.isEmpty()) res+=pq.poll();
        }
        return res;
    }
}