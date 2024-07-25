class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generate(0,s,s.length(),ans,new ArrayList<>());
        return ans;
    }
    public void generate(int ind,String s,int n,List<List<String>> ans,List<String> ds){
        if(ind==n){
            if(check(ds)) ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<n;i++){
            ds.add(s.substring(ind,i+1));
            generate(i+1,s,n,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public boolean check(List<String> ds){
        for(String str : ds){
            if(!isPalindrome(str)) return false;
        }
        return true;
    }
    public boolean isPalindrome(String str){
        int len = str.length();
        if(len==0) return false;
        int a=0,b=len-1;
        while(a<b){
            if(str.charAt(a++)!=str.charAt(b--)) return false;
        }
        return true;
    }
}