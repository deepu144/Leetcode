class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length(),lastNode=-1,max=1;
        int[] inDegree=new int[n];
        int[][] dp=new int[n][26];
        Set<Integer> set=new HashSet<>();
        List<Integer>[] adj=new List[n];
        for(int  i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges){
            adj[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.offer(i);
                dp[i][colors.charAt(i)-'a']++;
                set.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            for(int neighbour : adj[node]){
                if(set.contains(neighbour)){
                    for(int i=0;i<26;i++){
                        dp[node][i]=Math.max(dp[node][i],dp[neighbour][i]);
                        max=Math.max(dp[node][i],max);
                    }
                }else{
                    inDegree[neighbour]--;
                    for(int i=0;i<26;i++){
                        dp[neighbour][i]=Math.max(dp[neighbour][i],dp[node][i]);
                        max=Math.max(dp[node][i],max);
                    }
                    if(inDegree[neighbour]==0){
                        q.offer(neighbour);
                        char ch=colors.charAt(neighbour);
                        dp[neighbour][ch-'a']++;
                        max=Math.max(dp[neighbour][ch-'a'],max);
                        set.add(neighbour);
                    }
                }
            }
        }
        if(set.size()!=n) return -1;
        return max;
    }
}