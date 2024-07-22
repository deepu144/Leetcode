class Solution {
    StringBuilder sb = new StringBuilder();
    boolean f = false;
    int plusOrMinus=1;
    public int myAtoi(String s) {
        s=s.trim();
        int ans=0,n=s.length();
        add(0,s,n);
        try{
            if(sb.length()==0) return 0;
            ans=Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            if(sb.length()<10) return 0;
            ans= plusOrMinus==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if(plusOrMinus==1 && ans<0) return Integer.MAX_VALUE;
        else if(plusOrMinus==0 && ans>0) return Integer.MIN_VALUE;
        return ans;
    }

    public void add(int i,String s,int n){
        if(i==n) return;
        char ch = s.charAt(i);
        if((ch=='+' ||ch=='-')&& !f){
            sb.append(ch);
            f=true;
            plusOrMinus = ch=='+'?1:0;
        }else if(!Character.isDigit(ch)) return;
        else{
            sb.append(ch);
            f=true;
        }
        add(i+1,s,n);
    }
}