class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int[] dp=new int[n];
        int[] hash=new int[n];
        int maxi=0,lastIndex=0;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            hash[i]=i;
            dp[i]=1;
            for(int j=0;j<i;j++){
                if((arr[i]%arr[j]==0) && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(hash[lastIndex]!=lastIndex){
            res.add(arr[lastIndex]);
            lastIndex=hash[lastIndex];
        }
        res.add(arr[lastIndex]);
        Collections.reverse(res);
        return res;
    }
}