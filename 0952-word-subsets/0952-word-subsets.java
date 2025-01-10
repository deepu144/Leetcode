class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n=words2.length;
        int[] hash=new int[26];
        for(int j=0;j<n;j++){
            String s=words2[j];
            int[] temp=new int[26];
            for(int i=0;i<s.length();i++){
                temp[s.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++) hash[i]=Math.max(hash[i],temp[i]);
        }
        List<String> res=new ArrayList<>();
        for(String s : words1) if(isSubset(s,hash)) res.add(s);
        return res;
    }
    public boolean isSubset(String s,int[] hash){
        int n=s.length();
        int[] arr=new int[26];
        for(int i=0;i<n;i++) arr[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++) if(arr[i]<hash[i]) return false;
        return true;
    }
}