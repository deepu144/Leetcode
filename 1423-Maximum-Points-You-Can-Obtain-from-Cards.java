class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int a=0,b=n-k;
        int max=0,sum=0;
        int curr=0,s=n-k;
        for(int i=0;i<n;i++){
            sum+=cardPoints[i];
            if(i<s){
                curr+=cardPoints[i];
            }
        }
        max=Math.max(max,sum-curr);
        while(b<n){
            if(b-a+1>s){
                curr-=cardPoints[a];
                a++;
                curr+=cardPoints[b];
            }
            max=Math.max(max,sum-curr);
            b++;
        }
        return max;
    }
}