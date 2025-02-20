class Solution {
    public int maximumLength(String s) {
        int n=s.length(),max=-1;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                String t=s.substring(i,j);
                int m=t.length();
                if(!isSame(t,m) || map.containsKey(t)) continue;
                int count=check(s,t,n);
                map.put(t,count);
                max=Math.max(max,check(s,t,n));
            }
        }
        return max;
    }
    public int check(String s,String t,int n){
        int m=t.length(),count=0;
        for(int i=0;i<=n-m;i++){
            int j=i,k=0;
            boolean f=true;
            while(k<m){
                if(s.charAt(j)!=t.charAt(k)){
                    f=false;
                    break;
                }
                j++;
                k++;
            }
            if(f) count++;
            if(count==3) return m;
        }
        return -1;
    }
    public boolean isSame(String s,int n){
        for(int i=1;i<n;i++) if(s.charAt(i-1)!=s.charAt(i)) return false;
        return true;
    }
}