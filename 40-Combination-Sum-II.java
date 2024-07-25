class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,arr,arr.length,target,ans,new ArrayList<>());
        return ans;
    }    
    public void generate(int i,int[] arr,int n,int sum,List<List<Integer>> ans,List<Integer> ds){
        if(sum==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int j=i;j<n;j++){
            if(j>i && arr[j]==arr[j-1]) continue;
            if(arr[j]>sum) break;
            ds.add(arr[j]);
            generate(j+1,arr,n,sum-arr[j],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}