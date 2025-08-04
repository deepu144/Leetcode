class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,maxFruits=0,n=fruits.length,curr=0; 
        int[] basket=new int[100001];
        for(int right=0;right<n;right++){
            if(basket[fruits[right]]==0) curr++;
            basket[fruits[right]]++;
            while(curr >= 3){
                basket[fruits[left]]--;
                if(basket[fruits[left]]==0) curr--;
                left++;
            }
            maxFruits=Math.max(maxFruits, right-left+1);
        }
        return maxFruits;
    }
}