class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,arr,arr.length,target,ans,new ArrayList<>());
        return ans;
    }
    public void generate(int i,int[] arr,int n,int sum,List<List<Integer>> ans,List<Integer> sub){
        if(i==n){
            if(sum==0){
                ans.add(new ArrayList<>(sub));
            }
            return;
        }
        if(arr[i]<=sum){
            sub.add(arr[i]);
            generate(i,arr,n,sum-arr[i],ans,sub);
            sub.remove(sub.size()-1);
        }
        generate(i+1,arr,n,sum,ans,sub);
    }
}