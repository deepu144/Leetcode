class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length,temp=node1;
        int[] dist=new int[n];
        dist[node1]=1;
        while(edges[node1]!=-1 && dist[edges[node1]]==0){
            dist[edges[node1]]=dist[node1]+1;
            node1=edges[node1];
        }
        int min=(int)(1e9),index=n+1,curr=0;
        while(node2!=-1 && dist[node2]!=-1){
            curr++;
            if(dist[node2]!=0){
                dist[node2]=Math.max(dist[node2],curr);
                if(dist[node2]<=min){
                    if(dist[node2]==min) index=Math.min(index,node2);
                    else index=node2;
                    min=dist[node2];
                }
            }
            dist[node2]=-1;
            if(node2==temp) break;
            node2=edges[node2];
        }
        return index==n+1?-1:index;
    }
}