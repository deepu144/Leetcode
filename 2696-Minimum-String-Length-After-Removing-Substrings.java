class Solution {
    public int minLength(String s) {
        while(s.contains("AB")||s.contains("CD")){
            int a=s.indexOf("AB");
            if(a!=-1) s=new StringBuilder(s).delete(a,a+2).toString();
            int b=s.indexOf("CD");
            if(b!=-1) s=new StringBuilder(s).delete(b,b+2).toString();
        }
        return s.length();
    }
}