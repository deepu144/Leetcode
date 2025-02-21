class Solution {
    public int ladderLength(String big, String end, List<String> wordList) {
        int max=Integer.MAX_VALUE;
        if(!wordList.contains(end)) return 0;
        Queue<Pair> q = new LinkedList<>();
        int len=big.length();
        q.offer(new Pair(1,big));
        Set<String> visit = new HashSet<>(wordList);
        visit.remove(big);
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.s.equals(end)) return p.level;
            for(int i=0;i<len;i++){
                for(char c='a';c<='z';c++){
                    char[] ch = p.s.toCharArray();
                    ch[i]=c;
                    String s =new String(ch);
                    if(visit.contains(s)){
                        visit.remove(s);
                        q.offer(new Pair(p.level+1,s));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    int level;
    String s;
    public Pair(int level,String s){
        this.level=level;
        this.s=s;
    }
}