class Solution {
    public boolean canBeValid(String s, String lock) {
        int n=s.length(),i=0,a=0,b=0;
        if((n&1)==1) return false;
        while(i<n){
            if(lock.charAt(i)=='0'){
                a=Math.max(0,--a);
                b++;
            }else{
                if(s.charAt(i)=='('){
                    a++;
                    b++;
                }else{
                    a=Math.max(0,--a);
                    b--;
                }
            }
            i++;
            if(b<0) return false;
        }
        return a==0;
    }
}