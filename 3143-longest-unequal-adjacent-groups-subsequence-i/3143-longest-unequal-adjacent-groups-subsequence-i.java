class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        return getLongestSubsequence(words,groups,groups[0],n);
    }
    public List<String> getLongestSubsequence(String[] words,int[] groups,int curr,int n){
        List<String> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(curr==groups[i]){
                li.add(words[i]);
                curr=(curr==1)?0:1;
            }
        }
        return li;
    }
}