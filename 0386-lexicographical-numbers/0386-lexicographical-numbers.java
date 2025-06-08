class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> li=new ArrayList<>();
        helper(-1,n,li);
        return li;
    }
    public void helper(int n,int limit,List<Integer> li){
        for(int j=(n==-1?1:0);j<10;j++){
            int val = n==-1?j:(n*10)+j;
            if(val>limit) break;
            li.add(val);
            helper(val,limit,li);
        }
    }
}