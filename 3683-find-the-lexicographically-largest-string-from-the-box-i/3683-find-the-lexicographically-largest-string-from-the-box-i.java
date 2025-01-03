class Solution {
    public String answerString(String word, int numFriends) {
        int n=word.length(),max=n-numFriends+1;
        if(numFriends==1) return word;
        String ans="";
        for(int i=0;i<n;i++){
            String a=word.substring(i,Math.min(i+max,n));
            if(a.compareTo(ans)>0) ans=a;
        }
        return ans;
    }
}