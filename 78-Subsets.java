class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,arr,arr.length,ans);
        ans.add(new ArrayList<>());
        return ans;
    }
    public void generate(int i,int[] arr,int n,List<List<Integer>> ans){
        if(i==n) return;
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for(List<Integer> li : ans){
            temp.add(new ArrayList<>(li));
        }
        for(ArrayList<Integer> li : temp){
            li.add(arr[i]);
        }
        temp.add(new ArrayList<>(Arrays.asList(arr[i])));
        ans.addAll(temp);
        generate(i+1,arr,n,ans);
    }
}