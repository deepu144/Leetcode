class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] hash=new int[26];
        List<Integer> res=new ArrayList<>();
        Set<Character> set=new HashSet<>();
        int n=s.length(),left=0,right=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            hash[ch-'a']++;
        }
        while(right<n){
            char ch=s.charAt(right);
            set.add(ch);
            hash[ch-'a']--;
            if(hash[ch-'a']==0) set.remove(ch);
            if(set.isEmpty()){
                res.add(right-left+1);
                left=right+1;
            }
            right++;
        }
        return res;
    }
}