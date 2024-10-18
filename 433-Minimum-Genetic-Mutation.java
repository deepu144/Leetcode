class Solution {
    public int minMutation(String startGene, String end, String[] bank) {
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,startGene));
        int ans=0,n=end.length(),m=bank.length;
        boolean[] visited=new boolean[m];
        while(!q.isEmpty()){
            Pair p=q.poll();
            for(int i=0;i<m;i++){
                if(!visited[i]){
                    if(canChange(p.s,bank[i],n)){
                        visited[i]=true;
                        if(bank[i].equals(end)) return p.d+1;
                        q.offer(new Pair(p.d+1,bank[i]));
                    }
                }
            }
        }
        return -1;
    }
    public boolean canChange(String s,String t,int n){
        int a=0,b=n-1,cnt=0;
        while(a<b){
            if(s.charAt(a)!=t.charAt(a)) cnt++;
            if(s.charAt(b)!=t.charAt(b)) cnt++;
            if(cnt>=2) return false;
            a++;
            b--;
        }
        if(a==b) if(s.charAt(a)!=t.charAt(a)) cnt++;
        return cnt==1;
    }
}
class Pair{
    int d;
    String s;
    public Pair(int _d,String _s){
        d=_d;
        s=_s;
    }
}