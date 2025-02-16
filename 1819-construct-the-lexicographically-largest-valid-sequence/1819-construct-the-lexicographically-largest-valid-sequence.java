class Solution {
    public int[] constructDistancedSequence(int n) {
        int m=(n*2)-1;
        int[] arr=new int[m];
        Set<Integer> set=new HashSet<>();
        helper(arr,0,m,n,set);
        return arr;
    }
    public boolean helper(int[] arr,int ind,int m,int n,Set<Integer> set){
        if(ind>=m) return true;
        if(arr[ind]!=0) return helper(arr,ind+1,m,n,set);
        else{
            for(int i=n;i>=1;i--){
                if(set.add(i)){
                    if(i!=1){
                        if(ind+i>=m || arr[ind+i]!=0){
                            set.remove(i);
                            continue;
                        }
                        arr[ind]=arr[ind+i]=i;
                        if(helper(arr,ind+1,m,n,set)) return true;
                        arr[ind]=arr[ind+i]=0;
                        set.remove(i);
                    }else{
                        if(arr[ind]!=0){
                            set.remove(i);
                            continue;
                        }
                        arr[ind]=i;
                        if(helper(arr,ind+1,m,n,set)) return true;
                        arr[ind]=0;
                        set.remove(i);
                    }
                }
            }
        }
        return false;
    }
}