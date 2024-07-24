class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        List<String> hash = new ArrayList<>(Arrays.asList(\abc\,\def\,\ghi\,\jkl\,\mno\,\pqrs\,\tuv\,\wxyz\));
        generate(0,digits,digits.length(),ans,hash,new StringBuilder());
        return ans;
    }

    public void generate(int i,String digits,int n,List<String> ans,List<String> hash,StringBuilder sb){
        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }
        for(char c : hash.get(digits.charAt(i)-50).toCharArray()){
            sb.append(c);
            generate(i+1,digits,n,ans,hash,sb);
            sb.deleteCharAt(sb.length()-1);
        }   
    }
}