class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n=adjacentPairs.length,m=n+1;
        int[] res=new int[m];
        boolean[] seen=new boolean[n];
        HashMap<Integer,Integer> fre=new HashMap<>();
        HashMap<Integer,int[]> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            int[] a=adjacentPairs[i];
            fre.put(a[0],fre.getOrDefault(a[0],0)+1);
            fre.put(a[1],fre.getOrDefault(a[1],0)+1);

            int[] index=map.computeIfAbsent(a[0],k->new int[]{-1,-1});
            if(index[0]==-1) index[0]=i;
            else if(index[1]==-1) index[1]=i;

            index=map.computeIfAbsent(a[1],k->new int[]{-1,-1});
            if(index[0]==-1) index[0]=i;
            else if(index[1]==-1) index[1]=i;
        }
        int next=-1,j=0;
        for(int key : fre.keySet()){
            if(fre.get(key)==1){
                next=key;
                break;
            }
        }
        while(j<m){
            int[] p = map.get(next);
            for(int idx : p){
                if(idx==-1 || seen[idx]) continue;
                int[] pair = adjacentPairs[idx];
                seen[idx]=true;
                if(set.add(next)) res[j++]=next;
                next = (pair[0]==next) ? pair[1] : pair[0];
                if(set.add(next)) res[j++]=next;
            }
        }
        return res;
    }
}