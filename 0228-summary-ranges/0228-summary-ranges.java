class Solution {
    final String ARROW="->";
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        int n=nums.length;
        if(n==0) return res;
        int st=nums[0],curr=st+1;
        for(int i=1;i<n;i++){
            if(curr!=nums[i]){
                if(st==curr-1) res.add(st+"");
                else res.add(st+ARROW+(curr-1));
                st=nums[i];
                curr=st+1;
            }else curr++;
        }
        if(st==curr-1) res.add(st+"");
        else res.add(st+ARROW+(curr-1));
        return res;
    }
}