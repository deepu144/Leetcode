class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> li=new ArrayList<>();
        for(int[] a : rectangles) li.add(new int[]{a[0],a[2]});
        if(check(li)) return true;
        li=new ArrayList<>();
        for(int[] a : rectangles) li.add(new int[]{a[1],a[3]});
        return check(li);
    }
    public boolean check(List<int[]> list){
        Collections.sort(list,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int j=0,n=list.size();
        for(int i=0;i<n;i++){
            int[] curr=list.get(i);
            int[] point=list.get(j);
            if(point[1]>curr[0]) point[1]=Math.max(point[1],curr[1]);
            else{
                j++;
                list.set(j,curr);
            }
        }
        return j>1;
    }
}