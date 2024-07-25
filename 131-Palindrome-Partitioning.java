class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generate(0,s,s.length(),ans,new ArrayList<>());
        return ans;
    }
    public void generate(int ind,String s,int n,List<List<String>> ans,List<String> ds){
        if(ind==n){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(ind>n) return;
        for(int i=ind;i<n;i++){
            if(isPalindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                generate(i+1,s,n,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str,int a,int b){
        while(a<=b){
            if(str.charAt(a++)!=str.charAt(b--)) return false;
        }
        return true;
    }
}