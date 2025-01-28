class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n=vals.length;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            List<Integer> neig=new ArrayList<>();
            for(int node : adj[i]) neig.add(vals[node]);
            Collections.sort(neig,Collections.reverseOrder());
            int currentSum=vals[i];
            for (int j=0;j<Math.min(k, neig.size());j++) {
                if (neig.get(j)>0) currentSum+=neig.get(j);
                else break;   
            }
            max=Math.max(max,currentSum);
        }
        return max;
    }
}