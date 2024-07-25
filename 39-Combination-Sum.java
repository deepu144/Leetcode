class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,arr,arr.length,target,ans,new ArrayList<>());
        return ans;
    }
    public void generate(int i,int[] arr,int n,int sum,List<List<Integer>> ans,List<Integer> sub){
        if(sum==0){
            ans.add(new ArrayList<>(sub));
        }
        for(int j=i;j<n;j++){
            if(sum-arr[j]<0) continue;
            sub.add(arr[j]);
            generate(j,arr,n,sum-arr[j],ans,sub);
            sub.remove(sub.size()-1);
        }
    }
}