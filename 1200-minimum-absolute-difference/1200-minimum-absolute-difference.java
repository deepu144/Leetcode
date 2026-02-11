class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length, min = (int)(1e9);
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=1;i<n;i++) min = Math.min(min, arr[i]-arr[i-1]);
        for(int i=1;i<n;i++){
            if(arr[i] - arr[i-1] == min) res.add(List.of(arr[i-1],arr[i]));
        }
        return res;
    }
}