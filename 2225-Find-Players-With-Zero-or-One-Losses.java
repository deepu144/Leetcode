class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] win=new int[100001];
        int[] loss=new int[100001];
        TreeSet<Integer> num = new TreeSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int arr[] : matches){
            win[arr[0]]++;
            loss[arr[1]]++;
            num.add(arr[0]);
            num.add(arr[1]);
        }
        for(int n : num){
            if(win[n]>0 && loss[n]==0) ans.get(0).add(n);
            else if(loss[n]==1) ans.get(1).add(n);
        }
        return ans;
    }
}