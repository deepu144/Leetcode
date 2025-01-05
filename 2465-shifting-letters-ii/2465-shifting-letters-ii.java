class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] sweep=new int[n+1];
        for(int[] a : shifts){
            if(a[2]==0){
                sweep[a[0]]--;
                sweep[a[1]+1]++;
            }else{
                sweep[a[0]]++;
                sweep[a[1]+1]--;
            }
        }
        for(int i=1;i<=n;i++) sweep[i]+=sweep[i-1];
        char[] ch=s.toCharArray();
        for(int i=0;i<n;i++) ch[i]=(char)((ch[i]-'a'+(sweep[i]%26+26))%26+'a');
        return new String(ch);
    }
}