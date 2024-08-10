class Solution {
    public String repeatLimitedString(String s, int limit) {
        char[] ch=s.toCharArray();
        int n=s.length(),j=0;
        StringBuilder sb=new StringBuilder();
        int[] hash=new int[26];
        for(char c : ch) hash[c-'a']++;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.ch-a.ch);
        for(int i=0;i<26;i++) if(hash[i]!=0) pq.offer(new Pair((char)(i+'a'),hash[i]));
        while(!pq.isEmpty()){
            ArrayList<Pair> li=new ArrayList<>();
            boolean f=false;
            if(j==0){
                Pair p=pq.poll();
                int temp=limit;
                while(temp!=0 && p.fre!=0){
                    sb.append(p.ch);
                    p.fre--;
                    temp--;
                    j++;    
                }
                li.add(p);
                f=true;
            }else{
                Pair p=null;
                boolean isPresent=false;
                while(!pq.isEmpty() && ((p=pq.poll()).ch==sb.charAt(j-1))){
                    li.add(p);
                    isPresent=true;
                }
                if(p.ch!=sb.charAt(j-1)){
                    f=true;
                    if(isPresent){
                        sb.append(p.ch);
                        j++;
                        p.fre--;
                    }else{
                        int temp=limit;
                        while(temp!=0 && p.fre!=0){
                            sb.append(p.ch);
                            p.fre--;
                            temp--;
                            j++;    
                        }
                    }
                }
                li.add(p);
            }
            if(!f) break;
            for(Pair p : li) if(p.fre>0) pq.offer(p);
        }
        return sb.toString();
    }
}
class Pair{
    char ch;
    int fre;
    Pair(char ch,int fre){
        this.ch=ch;
        this.fre=fre;
    }
}