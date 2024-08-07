class Solution {
    public int maxArea(int h, int v, int[] hor, int[] ver) {
        int n=hor.length,m=ver.length;
        long rowMax=-1,colMax=-1;
        Arrays.sort(hor);
        Arrays.sort(ver);
        rowMax=Math.max(rowMax,Math.max(ver[0],v-ver[m-1]));
        colMax=Math.max(colMax,Math.max(hor[0],h-hor[n-1]));
        for(int i=1;i<n;i++) colMax=Math.max(colMax,hor[i]-hor[i-1]);
        for(int i=1;i<m;i++) rowMax=Math.max(rowMax,ver[i]-ver[i-1]);
        return (int)((rowMax*colMax)%(1000000007));
    }
}