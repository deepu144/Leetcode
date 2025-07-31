class Solution {
    public int maxProduct(String[] words) {
        int n=words.length,max=0;
        boolean[][] mat=new boolean[n][26];
        for(int i=0;i<n;i++){
            String s=words[i];
            int m=s.length();
            for(int j=0;j<m;j++) mat[i][s.charAt(j)-'a']=true;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                boolean flag=true;
                for(int k=0;k<26;k++){
                    if(mat[i][k] && mat[j][k]){
                        flag=false;
                        break;
                    }
                }
                if(flag) max=Math.max(max,words[i].length() * words[j].length());
            }
        }
        return max;
    }
}