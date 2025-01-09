class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=9;i++) dfs(n,i,res);
        return res;
    }
    public void dfs(int n,int val,List<Integer> res){
        if(val>n) return;
        res.add(val);
        for(int i=0;i<=9;i++){
            if(val*10+i>n) break;
            dfs(n,val*10+i,res);
        }
    }
}