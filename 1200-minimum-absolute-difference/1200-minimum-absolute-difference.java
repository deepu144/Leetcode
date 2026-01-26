class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length, min = (int)(1e9);
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=1;i<n;i++) min = Math.min(min, arr[i]-arr[i-1]);
        for(int i=1;i<n;i++){
            int diff = arr[i] - arr[i-1];
            if(diff == min) ans.add(List.of(arr[i-1],arr[i]));
        }
        return ans;
    }
}