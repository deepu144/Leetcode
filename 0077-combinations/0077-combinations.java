class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        helper(1,n,k,new ArrayList(),res);
        return res;
    }
    public void helper(int st,int n,int k,List<Integer> ds,List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=st;i<=n;i++){
            ds.add(i);
            helper(i+1,n,k-1,ds,res);
            ds.removeLast();
        }
    }
}