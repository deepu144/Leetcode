class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0,arr,arr.length,ans,new ArrayList<>());
        return ans;
    }
    public void subsets(int i,int[] arr,int n,List<List<Integer>> ans,List<Integer> subset){
        ans.add(new ArrayList<>(subset));
        for(int j=i;j<n;j++){
            if(i!=j && arr[j] == arr[j-1]) continue; 
            subset.add(arr[j]);
            subsets(j+1,arr,arr.length,ans,subset);
            subset.remove(subset.size()-1);
        }
    }
}