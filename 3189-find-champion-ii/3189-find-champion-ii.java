class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree=new int[n];
        for(int[] a : edges) inDegree[a[1]]++;
        int count=0,res=-1;
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                count++;
                res=i;
            }
        }
        if(count==1) return res;
        return -1;
    }
}