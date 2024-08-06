class Solution {
    public int minimumPushes(String word) {
        int[] hash=new int[26];
        for(char c: word.toCharArray()) hash[c-'a']++;
        PriorityQueue<Pair<Character,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(int i=0;i<26;i++) if(hash[i]>0) pq.offer(new Pair<>((char)(i+'a'),hash[i]));
        int res=0,time=1,temp=0;;
        while(!pq.isEmpty()){
            if(temp==8){
                temp=0;
                time++;
            }
            res+=(pq.poll().getValue()*time);
            temp++;
        }
        return res;
    }
}