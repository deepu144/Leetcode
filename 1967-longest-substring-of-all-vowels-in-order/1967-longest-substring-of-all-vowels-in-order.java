class Solution {
    record Pair(char ch,int cnt){}
    public int longestBeautifulSubstring(String word) {
        int n=word.length(),ct=1,ans=0;
        char prev=word.charAt(0);
        String vowel="aeiou";
        if(n<5) return 0;
        List<Pair> li=new ArrayList<>();
        for(int i=1;i<n;i++){
            char curr=word.charAt(i);
            if(curr==prev) ct++;
            else{
                li.add(new Pair(prev,ct));
                ct=1;
                prev=curr;
            }
        }
        li.add(new Pair(prev,ct));
        int i=0,size=li.size();
        while(i<size){
            while(i<size && li.get(i).ch!='a') i++;
            int j=0,len=0;
            while(i<size && j<5){
                char curr=vowel.charAt(j);
                Pair p = li.get(i);
                if(curr==p.ch){
                    i++;
                    j++;
                    len+=p.cnt;
                }else break;
            }
            if(j==5) ans=Math.max(ans,len);
        }
        return ans;
    }
}