class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> mono=new Stack<>();
        int n=prices.length;
        for(int i=0;i<n;i++){
            while(!mono.isEmpty() && prices[mono.peek()]>=prices[i]){
                int p=mono.pop();
                prices[p]-=prices[i];
            }
            mono.push(i);
        }
        return prices;
    }
}