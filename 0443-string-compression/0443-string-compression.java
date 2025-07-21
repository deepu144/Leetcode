class Solution {
    public int compress(char[] chars) {
        int n=chars.length,cnt=1,ans=0,j=0;
        char prev=chars[0];
        for(int i=1;i<n;i++){
            char curr = chars[i];
            if(curr==prev) cnt++;
            else{
                chars[j++]=prev;
                ans++;
                if(cnt>1){
                    String temp=cnt+"";
                    int len = temp.length();
                    ans+=len;
                    for(int k=0;k<len;k++) chars[j++]=temp.charAt(k);
                }
                prev=curr;
                cnt=1;
            }
        }
        ans++;
        chars[j++]=prev;
        if(cnt>1){
            String temp=cnt+"";
            int len = temp.length();
            ans+=len;
            for(int k=0;k<len;k++) chars[j++]=temp.charAt(k);
        }
        return ans;
    }
}