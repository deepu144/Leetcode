class Solution {
    public int maxLength(List<String> arr) {
        int n=arr.size();
        return helper(arr,n-1,new int[26]);
    }
    public int helper(List<String> arr,int i,int[] hash){
        if(i==-1) return 0;
        int notPick=helper(arr,i-1,hash);
        int pick=-1;
        int n=arr.get(i).length();
        String s=arr.get(i);
        if(isUnique(hash,s,n)){
            for(int j=0;j<n;j++) hash[s.charAt(j)-'a']++;
            pick=n+helper(arr,i-1,hash);
            for(int j=0;j<n;j++) hash[s.charAt(j)-'a']--;
        }
        return Math.max(pick,notPick);
    }

    public boolean isUnique(int[] hash,String s,int n){
        int[] sHash=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(sHash[ch-'a']!=0 || hash[ch-'a']!=0) return false;
            sHash[ch-'a']++;
        }
        return true;
    }
}