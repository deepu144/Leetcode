class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(helper(s,i,i+k,n)){
                boolean left = isValidINdex(i-1,n);
                boolean right = isValidINdex(i+k,n);
                if(left && right){
                    if(ch != s.charAt(i+k) && ch != s.charAt(i-1))
                        return true;
                }
                else if(left){
                    if(ch != s.charAt(i-1))
                        return true;
                }
                else if(right){
                    if(ch != s.charAt(i+k))
                        return true;
                }
                else{
                    return true;
                }
            }
        }

        return false;        
    }
    public boolean helper(String s,int start,int end,int n){
        char ch = ' ';
        for(int i=start;i<end;i++){
            if(!isValidINdex(i,n))
                return false;
            if(i == start)
                ch = s.charAt(i);
            else{
                if(ch != s.charAt(i))
                    return false;
            }
        }
        return true;
    }

    public boolean isValidINdex(int i,int n){
        return 0 <= i && i < n;
    }
}