class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n=s1.length(),noOfComponents=0,j=0,m=baseStr.length();
        DisJointSet ds=new DisJointSet(26);
        Set<Character> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        int[] map=new int[26];
        Arrays.fill(map,-1);
        for(int i=0;i<n;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            set.add(c1);
            set.add(c2);
            ds.union(c1-'a',c2-'a');
        }
        for(char ch : set) if(ds.parent[ch-'a']==ch-'a') noOfComponents++;
        PriorityQueue<Character>[] pq=new PriorityQueue[noOfComponents];
        for(int i=0;i<noOfComponents;i++) pq[i]=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            j = helper(j,s1.charAt(i),ds,map,pq);
            j = helper(j,s2.charAt(i),ds,map,pq);
        }
        for(int i=0;i<m;i++){
            char ch=baseStr.charAt(i);
            int ul_u = ds.find(ch-'a'),idx=map[ul_u];
            if(idx==-1) sb.append(ch);
            else sb.append(pq[idx].peek());
        }
        return sb.toString();
    }
    public int helper(int j,char ch,DisJointSet ds,int[] map,PriorityQueue<Character>[] pq){
        int ul_u=ds.find(ch-'a');
        int idx=map[ul_u];
        if(idx==-1){
            idx=j;
            map[ul_u]=j++;
        }
        pq[idx].offer(ch);
        return j;
    }
}
class DisJointSet{
    int[] parent;
    int[] size;
    public DisJointSet(int n){
        parent=new int[n];
        size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    public int find(int u){
        if(parent[u]==u) return u;
        return parent[u]=find(parent[u]);
    }
    public boolean union(int u,int v){
        int ul_u=find(u);
        int ul_v=find(v);
        if(ul_u==ul_v) return false;
        if(size[ul_u]>size[ul_v]){
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }else{
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }
        return true;
    }
}