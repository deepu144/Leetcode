class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<int[]> mono=new Stack<>();
        int n=prices.length;
        for(int i=0;i<n;i++){
            while(!mono.isEmpty() && mono.peek()[0]>=prices[i]){
                int[] p=mono.pop();
                prices[p[1]]=p[0]-prices[i];
            }
            mono.push(new int[]{prices[i],i});
        }
        return prices;
    }
}