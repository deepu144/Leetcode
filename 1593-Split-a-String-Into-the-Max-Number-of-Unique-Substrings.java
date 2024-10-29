class Solution {
    public int maxUniqueSplit(String s) {
        int n=s.length();
        return split(s,n,0,new HashSet<>());
    }
    public int split(String s,int n,int ind,Set<String> set){
        if(ind==n) return 0;
        int max=-1;
        for(int i=ind;i<n;i++){
            String t=s.substring(ind,i+1);
            if(set.add(t)){
                max=Math.max(max,1+split(s,n,i+1,set));
                set.remove(t);
            }
        }
        return max;
    }
}