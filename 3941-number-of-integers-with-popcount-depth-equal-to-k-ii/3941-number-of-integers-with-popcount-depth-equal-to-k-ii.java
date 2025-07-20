class Solution {
    public int[] popcountDepth(long[] nums, long[][] queries) {
        int n=nums.length,m=0;
        for(long[] query : queries) if(query[0]==1L) m++;
        int[] ans=new int[m];
        int MAX=6;
        Fenwick[] bits = new Fenwick[MAX];
        for(int i=0;i<MAX;i++) bits[i]=new Fenwick(n);
        for(int i=0;i<n;i++){
            int p = popCountDepth(nums[i]);
            bits[p].update(i,1);
        }
        int j=0;
        for(long[] q : queries){
            if(q[0]==1){
                int l=(int)q[1],r=(int)q[2],k=(int)q[3];
                if(k>=0 && k<=MAX) ans[j]=bits[k].rangeQuery(l,r);
                else ans[j]=0;
                j++;
            }else{
                int idx=(int)q[1];
                long val=q[2];
                int oldD = popCountDepth(nums[idx]);
                bits[oldD].update(idx,-1);
                nums[idx]=val;
                int newD=popCountDepth(val);
                bits[newD].update(idx,1);
                
            }
        }
        return ans;
    }
    public int popCountDepth(long x){
        int cnt=0;
        while(x!=1){
            x=Long.bitCount(x);
            cnt++;
        }
        return cnt;
    }
}

class Fenwick {
    private final int n;
    private final int[] bit;
    public Fenwick(int size) {
        n = size;
        bit = new int[n+1];
    }
    public void update(int i, int v) {
        for (int x = i+1; x <= n; x += x & -x)
            bit[x] += v;
    }
    public int query(int i) {
        int s = 0;
        for (int x = i+1; x > 0; x -= x & -x)
            s += bit[x];
        return s;
    }
    public int rangeQuery(int l, int r) {
        if (l > r) return 0;
        return query(r) - (l==0 ? 0 : query(l-1));
    }
}



