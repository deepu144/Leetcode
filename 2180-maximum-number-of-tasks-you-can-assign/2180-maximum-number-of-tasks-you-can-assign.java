class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n=tasks.length,m=workers.length,ans=0,start=0,end=Math.min(m,n);
        while(start<=end){
            int mid= start+(end-start)/2;
            if(isPossible(tasks,workers,m,pills,strength,mid)){
                ans=mid;
                start=mid+1;
            }else end=mid-1;
        }
        return ans;
    }
    public boolean isPossible(int[] tasks,int[] workers,int m,int pills,int strength,int mid){
        int[] t=new int[mid];
        int[] w=new int[mid];
        for(int i=0;i<mid;i++){
            t[i]=tasks[i];
            w[i]=workers[m-mid+i];
        }
        for(int i=mid-1 ; i>=0 && pills>0 ;i--){
            if(t[i]>w[i]){
                pills--;
                t[i]-=strength;
            }
        }
        Arrays.sort(t);
        for(int i=0;i<mid;i++) if(t[i]>w[i]) return false;
        return true;
    }
}