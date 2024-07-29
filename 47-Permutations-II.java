class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        generate(0,nums,nums.length,ans);
        return new ArrayList<>(ans);
    }
    public void generate(int ind,int[] arr,int n,Set<List<Integer>> ans){
        if(ind==n){
            List<Integer> curr = new ArrayList<>();
            for(int a : arr) curr.add(a);
            ans.add(curr);
            return;
        }
        for(int i=ind;i<n;i++){
            swap(arr,i,ind);
            generate(ind+1,arr,n,ans);
            swap(arr,i,ind);
        }
    }
    public void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}