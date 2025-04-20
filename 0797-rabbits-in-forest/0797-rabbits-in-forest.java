class Solution {
    public int numRabbits(int[] answers) {
        int[] hash=new int[1001];
        int n=answers.length,count=0;
        for(int val : answers) hash[val]++;
        count+=hash[0];
        for(int i=2;i<1001;i++){
            if(hash[i]==0) continue;
            if(hash[i]<=i+1){
                count+=(i+1);
                continue;
            }
            int q=hash[i]/(i+1),rem=hash[i]%(i+1);
            count+=(q*(i+1));
            if(rem!=0) count+=(i+1);
        }
        return count+(hash[1]%2==0?hash[1]:hash[1]+1);
    }
}