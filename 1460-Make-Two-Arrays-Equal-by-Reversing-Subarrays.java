class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash = {-1,-1,-1};
        int count=0;
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']=i;
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1){
                count+=(1+Math.min(hash[0],Math.min(hash[1],hash[2])));;
            }
        }
        return count;
    }
}