class Solution {
    public int minimumPushes(String word) {
        int[] hash=new int[26];
        for(char c: word.toCharArray()) hash[c-'a']++;
        Arrays.sort(hash);
        int res=0,time=1,temp=0;
        for(int i=25;i>=0;i--){
            if(hash[i]!=0){
                if(temp==8){
                    temp=0;
                    time++;
                }
                res+=(hash[i]*time);
                temp++;
            }
        }
        return res;
    }
}