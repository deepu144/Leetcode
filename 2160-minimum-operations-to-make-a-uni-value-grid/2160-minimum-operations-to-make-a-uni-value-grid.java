class Solution {
    public int minOperations(int[][] grid, int x) {
        int row=grid.length,col=grid[0].length,test=grid[0][0]%x,min=(int)(1e9);
        TreeSet<Integer> set=new TreeSet<>();
        long sum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]%x!=test) return -1;
                if(set.add(grid[i][j])) sum+=grid[i][j];
            }
        }
        List<Integer> li=new ArrayList<>(set);
        int n=set.size(),avg=(int)(sum/n),mid=getCeil(avg,li,n),t=mid,prev=(int)(1e9);
        while(t>=0){
            int curr=operations(grid,row,col,li.get(t),x);
            if(curr<=prev){
                prev=curr;
                min=Math.min(min,curr);
            }else break;
            t--;
        }
        t=mid+1;
        prev=(int)(1e9);
        while(t<n){
            int curr=operations(grid,row,col,li.get(t),x);
            if(curr<=prev){
                prev=curr;
                min=Math.min(min,curr);
            }else break;
            t++;
        }
        return min;
    }
    public int operations(int[][] grid,int row,int col,int val,int x){
        long diff=0;
        for(int i=0;i<row;i++) for(int j=0;j<col;j++) diff+=Math.abs(grid[i][j]-val);
        diff/=x;
        return (int)(diff);
    }
    public int getCeil(int x,List<Integer> arr,int n){
        int start=0,end=n-1;
        if(arr.get(n-1)<x) return -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr.get(mid)==x) return mid;
            if(arr.get(mid)>x) end=mid-1;
            else start=mid+1;
        }
        return start;
    }
}